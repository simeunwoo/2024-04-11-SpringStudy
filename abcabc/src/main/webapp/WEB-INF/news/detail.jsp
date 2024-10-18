<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.listBtn {
    display: flex;
    justify-content: center; 
    margin-top: 20px; 
    margin-bottom: 20px; 
}
.listBtn .btn {
    padding: 10px 20px;
    background-color: #666;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.listBtn .btn:hover {
    background-color: #000;
}
.news-poster {
        margin-bottom: 20px; 
    }
</style>
</head>
<body>
   <section>
     <div class="news-page-banner">
         <div class="container">
         </div>
      </div>
      <div class="inner-information-text">
         <div class="container">
            <h3>News</h3>
            <ul class="breadcrumb">
               <li><a href="../main/main.do">Home</a></li>
               <li class="active"><a href="../news/list.do">News</a></li>
            </ul>
         </div>
      </div>
     </section>
     <section id="detailApp" style="margin-top: 50px;">
        <div class="row">
           <div class="container">
              <div class="col-md-9">
                 <div class="news-poster">
                    <div class="news-poster">
                       <img :src="vo.poster" class="img-responsive" alt="#" style="width: 1100px;" />
                    </div>
                    <div class="news-cont">
                       <div class="post-people">
                          <div class="left-profile">
                             <div class="post-info">
                                <img src="../images/news-profile.png" alt="#" />
                                <span>
                                   <h2>{{vo.author}}</h2>
                                   <h5>{{vo.ftime}}</h5>
                                </span>
                             </div>
                             <span class="share"></span>
                          </div>
                       </div>
                       <div class="post-heading" style="margin-bottom: 30px;">
                          <h2>{{vo.title}}</h2>
                          <p>{{vo.content}}</p>
                          <div class="listBtn">
                             <a class="btn" href="../news/list.do">목록</a>
                          </div>
                       </div>
                    </div>
                 </div>
              </div>
              <div class="col-md-3">
                 <!-- <div class="blog-sidebar">
                    <div class="search-bar-blog">
                       <form>
                          <input type="text" placeholder="search" />
                          <button><i class="fa fa-search" aria-hidden="true"></i></button>
                       </form>
                    </div>
                 </div> -->
                 <div class="blog-sidebar">
                     <h4 class="heading">Top Categories</h4>
                     <div class="category-menu">
                        <ul>
                           <li><a href="#">Cricket</a></li>
                           <li><a href="#">Football</a></li>
                           <li><a href="#">Hockey</a></li>
                           <li><a href="#">Tennis</a></li>
                           <li><a href="#">Basketball</a></li>
                           <li><a href="#">Golf</a></li>
                           <li><a href="#">Cycling</a></li>
                           <li><a href="#">Motorsports</a></li>
                        </ul>
                     </div>
                  </div>
                 <div class="blog-sidebar">
                     <h4 class="heading">Popular News</h4>
                     <div class="category-menu">
                        <ul>
                           <li>
                              <span><img src="../images/profile-img2.png" alt="#"></span>
                              <span>
                                 <p>Two touch penalties, imaginary cards</p>
                                 <p class="date">22 Feb, 2016</p>
                              </span>
                           </li>
                        </ul>
                     </div>
                  </div>
                 <aside id="sidebar" class="right-bar">
	                 <div class="banner">
	                    <img class="img-responsive" src="../images/img-02.jpg" alt="#">
	                 </div>
	              </aside>
	              <aside id="sidebar" class="right-bar">
	                 <div class="banner">
	                    <img class="img-responsive" src="../images/img-03.jpg" alt="#">
	                 </div>
	              </aside>
              </div>
           </div>
        </div>
     </section>
    <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    			vo:{},
    			nno:${nno},
    			
    		}
    	},
    	mounted(){
    		axios.get('../news/detail_vue.do',{
    			params:{
    				nno:this.nno
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data
    		}).catch(error=>{
    			console.log(error.response)
    		})
    	  }
    	}).mount('#detailApp')
    </script>
</body>
</html>