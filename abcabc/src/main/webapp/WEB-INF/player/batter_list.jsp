<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<script src="https://cdn.jsdelivr.net/npm/vue@3.2.45/dist/vue.global.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->
    <script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    <div style="height:500px"></div>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <!-- First slide -->
        <div class="item active deepskyblue" data-ride="carousel" data-interval="5000">
            <img src="m1.jpg" alt="Slide 1 Image" style="width:900px;height:720px" class="img-fluid">
            <div class="carousel-caption">
                <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                    <div class="slider-contant" data-animation="animated fadeInRight">
                        <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Deserve</span><br>to win!</h3>
                        <p>If you use this site regularly and would like to help keep the site on the Internet,<br>
                            please consider donating a small sum to help pay..
                        </p>
                        <button class="btn btn-primary btn-lg">Read More</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.item -->
        <!-- Second slide -->
        <div class="item skyblue" data-ride="carousel" data-interval="5000">
            <img src="m2.jpg" alt="Slide 2 Image" class="img-fluid">
            <div class="carousel-caption">
                <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                    <div class="slider-contant" data-animation="animated fadeInRight">
                        <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Deserve</span><br>to win!</h3>
                        <p>You can make a case for several potential winners of<br>the expanded European Championships.</p>
                        <button class="btn btn-primary btn-lg">Button</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.item -->
        <!-- Third slide -->
        <div class="item darkerskyblue" data-ride="carousel" data-interval="5000">
            <img src="m3.jpg" alt="Slide 3 Image" class="img-fluid">
            <div class="carousel-caption">
                <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                    <div class="slider-contant" data-animation="animated fadeInRight">
                        <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Deserve</span><br>to win!</h3>
                        <p>You can make a case for several potential winners of<br>the expanded European Championships.</p>
                        <button class="btn btn-primary btn-lg">Button</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.item -->
    </div>

    <div class="container">
        <div class="header-top">
            <div class="row">
                <h4>Points Table</h4>
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs">
                        <table class="table table-bordered table-hover">
                            <tr>
                                <th></th>
                                <th>이름</th>
                                <th>소속팀</th>
                                <th>나이</th>
                                <th>게임</th>
                                <th>홈런</th>
                                <th>안타</th>
                                <th>타점</th>
                                <th>볼넷</th>
                                <th>삼진</th>
                                <th>WAR</th>
                            </tr>
                            <tr v-for="vo in list">
                                <td>{{vo.bno}}</td>
                                <td>
                                    <a :href="'../player/batter_detail.do?bno=' + vo.bno">{{vo.name}}</a>
                                </td>
                                <td><img :src="vo.logo">{{vo.team}}</td>
                                <td>{{vo.age}}</td>
                                <td>{{vo.game}}</td>
                                <td>{{vo.homerun}}</td>
                                <td>{{vo.h1}}</td>
                                <td>{{vo.rbi}}</td>
                                <td>{{vo.ball}}</td>
                                <td>{{vo.strikeout}}</td>
                                <td>{{vo.war}}</td>
                            </tr>
                        </table>

                        <div class="text-center">
                            <table>
                                <tr>
                                    <td colspan="5" class="text-center">
                                        <input type="button" class="btn btn-sm btn-success" value="이전" @click="prev()">
                                        {{curpage}} 페이지 / {{totalpage}} 페이지
                                        <input type="button" class="btn btn-sm btn-success" value="다음" @click="next()">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </div>

    <script>
        let playerApp = Vue.createApp({
            data() {
                return {
                    list: [],
                    curpage: 1,
                    totalpage: 0
                }
            },
            mounted() {
                this.dataRecv()
            },
            methods: {
                prev() {
                    this.curpage = this.curpage > 1 ? this.curpage - 1 : this.curpage
                    this.dataRecv()
                },
                next() {
                    this.curpage = this.curpage < this.totalpage ? this.curpage + 1 : this.curpage
                    this.dataRecv()
                },
                dataRecv() {
                    axios.get('../player/batter_list_vue.do', {
                        params: {
                            page: this.curpage
                        }
                    }).then(response => {
                        console.log(response.data)
                        this.list = response.data.list
                        this.curpage = response.data.curpage
                        this.totalpage = response.data.totalpage
                    }).catch(error => {
                        console.log(error.response)
                    })
                }
            }
        }).mount('.container')
        console.log(Vue);
    </script>
</body>

</html>