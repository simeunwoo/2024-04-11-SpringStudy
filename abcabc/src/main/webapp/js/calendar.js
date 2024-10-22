!function() {
    var today = moment();

    function Calendar(selector, events) {
        this.el = document.querySelector(selector);
        this.events = events;
        this.current = moment().date(1);
        this.draw();
        var current = document.querySelector('.today');
        if (current) {
            var self = this;
            window.setTimeout(function() {
                self.openDay(current);
            }, 500);
        }
    }

    Calendar.prototype.draw = function() {
        this.drawHeader();
        this.drawMonth();
        this.drawLegend();
    }

    Calendar.prototype.drawHeader = function() {
        var self = this;
        if (!this.header) {
            this.header = createElement('div', 'header');
            this.title = createElement('h1');

            var right = createElement('div', 'right');
            right.addEventListener('click', function() { self.nextMonth(); });

            var left = createElement('div', 'left');
            left.addEventListener('click', function() { self.prevMonth(); });

            this.header.appendChild(this.title); 
            this.header.appendChild(right);
            this.header.appendChild(left);
            this.el.appendChild(this.header);
        }

        this.title.innerHTML = this.current.format('MMMM YYYY');
    }

    Calendar.prototype.drawMonth = function() {
        var self = this;

        this.events.forEach(function(ev) {
            ev.date = self.current.clone().date(Math.random() * (29 - 1) + 1);
        });

        if (this.month) {
            this.oldMonth = this.month;
            this.oldMonth.className = 'month out ' + (self.next ? 'next' : 'prev');
            this.oldMonth.addEventListener('webkitAnimationEnd', function() {
                self.oldMonth.parentNode.removeChild(self.oldMonth);
                self.month = createElement('div', 'month');
                self.backFill();
                self.currentMonth();
                self.fowardFill();
                self.el.appendChild(self.month);
                window.setTimeout(function() {
                    self.month.className = 'month in ' + (self.next ? 'next' : 'prev');
                }, 16);
            });
        } else {
            this.month = createElement('div', 'month');
            this.el.appendChild(this.month);
            this.backFill();
            this.currentMonth();
            this.fowardFill();
            this.month.className = 'month new';
        }
    }

    Calendar.prototype.backFill = function() {
        var clone = this.current.clone();
        var dayOfWeek = clone.day();

        if (!dayOfWeek) { return; }

        clone.subtract('days', dayOfWeek); // Adjusted to fill the week correctly

        for (var i = dayOfWeek; i > 0; i--) {
            this.drawDay(clone.add('days', 1));
        }
    }

    Calendar.prototype.fowardFill = function() {
        var clone = this.current.clone().add('months', 1).subtract('days', 1);
        var dayOfWeek = clone.day();

        for (var i = dayOfWeek; i < 6; i++) { // Change to 6 to complete the week
            this.drawDay(clone.add('days', 1));
        }
    }

    Calendar.prototype.currentMonth = function() {
        var clone = this.current.clone();

        while (clone.month() === this.current.month() || clone.day() !== 0) {
            this.drawDay(clone);
            clone.add('days', 1);
        }
    }

    Calendar.prototype.getWeek = function(day) {
        if (!this.week || day.day() === 0) {
            this.week = createElement('div', 'week');
            this.month.appendChild(this.week);
        }
    }

    Calendar.prototype.drawDay = function(day) {
        var self = this;
        this.getWeek(day);

        var outer = createElement('div', this.getDayClass(day));
        outer.addEventListener('click', function() {
            self.openDay(this);
        });

        var name = createElement('div', 'day-name', day.format('ddd'));
        var number = createElement('div', 'day-number', day.format('DD'));

        var events = createElement('div', 'day-events');
        this.drawEvents(day, events);

        outer.appendChild(name);
        outer.appendChild(number);
        outer.appendChild(events);
        this.week.appendChild(outer);
    }

    Calendar.prototype.drawEvents = function(day, element) {
        if (day.month() === this.current.month()) {
            var todaysEvents = this.events.reduce(function(memo, ev) {
                if (ev.date.isSame(day, 'day')) {
                    memo.push(ev);
                }
                return memo;
            }, []);

            todaysEvents.forEach(function(ev) {
                var evSpan = createElement('span', ev.color);
                element.appendChild(evSpan);
            });
        }
    }

    Calendar.prototype.getDayClass = function(day) {
        var classes = ['day'];
        if (day.month() !== this.current.month()) {
            classes.push('other');
        } else if (today.isSame(day, 'day')) {
            classes.push('today');
        }
        return classes.join(' ');
    }

    Calendar.prototype.openDay = function(el) {
        var details, arrow;
        var dayNumber = +el.querySelectorAll('.day-number')[0].innerText || +el.querySelectorAll('.day-number')[0].textContent;
        var day = this.current.clone().date(dayNumber);

        var currentOpened = document.querySelector('.details');

        if (currentOpened && currentOpened.parentNode === el.parentNode) {
            details = currentOpened;
            arrow = document.querySelector('.arrow');
        } else {
            if (currentOpened) {
                currentOpened.className = 'details out';
                currentOpened.addEventListener('animationend', function() {
                    currentOpened.parentNode.removeChild(currentOpened);
                });
            }

            details = createElement('div', 'details in');
            arrow = createElement('div', 'arrow');

            details.appendChild(arrow);
            el.parentNode.appendChild(details);
        }

        var todaysEvents = this.events.reduce(function(memo, ev) {
            if (ev.date.isSame(day, 'day')) {
                memo.push(ev);
            }
            return memo;
        }, []);

        this.renderEvents(todaysEvents, details);
        arrow.style.left = el.offsetLeft - el.parentNode.offsetLeft + 40 + 'px';
    }

    Calendar.prototype.renderEvents = function(events, element) {
        if (events.length === 0) {
            var insert = createElement('div', 'empty-message', 'No Events');
            element.appendChild(insert);
        } else {
            events.forEach(function(ev) {
                var div = createElement('div', 'event', ev.event);
                element.appendChild(div);
            });
        }
    }

    Calendar.prototype.nextMonth = function() {
        this.current.add('months', 1);
        this.next = true;
        this.draw();
    }

    Calendar.prototype.prevMonth = function() {
        this.current.subtract('months', 1);
        this.next = false;
        this.draw();
    }

    function createElement(tagName, className, innerHTML) {
        var element = document.createElement(tagName);
        if (className) { element.className = className; }
        if (innerHTML) { element.innerHTML = innerHTML; }
        return element;
    }

    window.Calendar = Calendar;

    document.addEventListener('DOMContentLoaded', function() {
        var calendar = new Calendar('#calendar', [
            { event: 'Event 1', color: 'event-color-1', date: moment().date(5) },
            { event: 'Event 2', color: 'event-color-2', date: moment().date(15) },
            { event: 'Event 3', color: 'event-color-3', date: moment().date(20) }
        ]);
    });
}();