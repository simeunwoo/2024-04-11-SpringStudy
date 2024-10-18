<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style type="text/css">
.stadium-post-widget {
    margin-bottom: 30px;
    border: 1px solid #ebebeb; 
    border-radius: 8px;
    overflow: hidden;
}
.stadium-post-widget .image-container {
    position: relative;
    overflow: hidden;
}
.stadium-post-widget img {
    width: 100%; 
    height: 220px;
    object-fit: fill; 
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    transition: transform 0.3s ease;
}
.stadium-post-widget .overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.3);
    opacity: 0; 
    transition: opacity 0.3s ease;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
}
.stadium-post-widget .image-container:hover img {
    transform: scale(1.05);
}
.stadium-post-widget .image-container:hover .overlay {
    opacity: 1; 
}
.stadium-post-detail {
    margin-top: 15px;
    margin-bottom: 5px;
    margin-left: 10px;
    margin-right: 10px;
    padding-left: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.stadium-post-detail .info {
    display: block;
}
.stadium-post-detail .btn {
    padding: 12px 25px;
    background-color: #666;
    color: white;
    transform: translate(-10px, -8px);
    transition: background-color 0.3s ease;
}
.stadium-post-detail .btn:hover {
    background-color: #000;
}
.stadium-post-detail h2 {
    margin-bottom: -10px;
}
.stadium-post-detail h2 a:hover {
    color: #666; 
}
span.loc {
    display: inline-block;
    margin-bottom: 8px;
}
</style>
</head>
<body>
    <section>
        <div class="stadium-page-banner">
            <div class="container">
            </div>
        </div>
        <div class="inner-information-text">
            <div class="container">
                <h3>Stadium</h3>
                <ul class="breadcrumb">
                    <li><a href="../main/main.do">Home</a></li>
                    <li class="active"><a href="../stadium/list.do">Stadium</a></li>
                </ul>
            </div>
        </div>
    </section>

    <section class="contant" id="listApp" style="margin-top: 50px;margin-bottom: 30px;">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" v-for="vo in stadium_list">
                <div class="stadium-post-widget">
                    <a :href="'../stadium/detail.do?no='+vo.no">
                      <div class="image-container">
                        <img :src="vo.poster" alt="" class="img-responsive">
                        <div class="overlay"></div>
                       </div>
                    </a>
                    <div class="stadium-post-detail">
                        <div class="info">
                            <h2 class="clamp-text-one-line">
                                <a :href="'../stadium/detail.do?no='+vo.no">{{vo.name}}</a>
                            </h2>
                            <span class="loc">{{vo.location}} / {{vo.hometeam}}</span>
                        </div>
                        <a class="btn" :href="'../stadium/detail.do?no='+vo.no"><i class="fas fa-arrow-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>


        <!-- Pagination
        <div class="col-12">
            <div class="pagination-area d-sm-flex mt-15" style="margin-left: -250px;"> 
                <nav aria-label="#" style="width: 100%;">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" @click="prev()">
                                <i class="fa fa-angle-double-left" aria-hidden="true"></i>
                            </a>
                        </li>
                        <li :class="i === curpage ? 'page-item active' : 'page-item'" v-for="i in range(startPage, endPage)">
                            <a class="page-link" @click="pageChange(i)">{{ i }}</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" @click="next()">
                                <i class="fa fa-angle-double-right" aria-hidden="true"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>-->
    </section> 

    <script>
        let listApp = Vue.createApp({
            data() {
                return {
                    stadium_list: [],
                    curpage: 1,
                    totalpage: 0,
                    startPage: 0,
                    endPage: 0
                }
            },
            mounted() {
                this.dataRecv()
            },
            methods: {
                prev() {
                    if (this.startPage > 1) {
                        this.curpage = this.startPage - 1
                        this.dataRecv()
                    }
                },
                next() {
                    if (this.endPage < this.totalpage) {
                        this.curpage = this.endPage + 1
                        this.dataRecv()
                    }
                },
                pageChange(page) {
                    this.curpage = page
                    this.dataRecv()
                },
                range(start, end) {
                    let arr = []
                    for (let i = start; i <= end; i++) {
                        arr.push(i)
                    }
                    return arr
                },
                dataRecv() {
                    axios.get('../stadium/list_vue.do', {
                        params: { page: this.curpage }
                    }).then(response => {
                        console.log(response.data)
                        this.stadium_list = response.data.list
                        this.curpage = response.data.curpage
                        this.totalpage = response.data.totalpage
                        this.startPage = response.data.startPage
                        this.endPage = response.data.endPage
                    }).catch(error => {
                        console.log(error.response)
                    })
                }
            }
        }).mount('#listApp')
    </script>
</body>
</html>