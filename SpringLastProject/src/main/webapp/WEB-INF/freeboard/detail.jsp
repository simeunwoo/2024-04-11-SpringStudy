<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>상세 보기</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80" id="detailApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
    	let detailApp=Vue.createApp({
    		data(){
    			return{
    				vo:{},
    				no:${no},
    				sessionId:'${sessionId}'
    			}
    		},
    		mounted(){
    			axios.get('../freeboard/detail_vue.do',{
    				params:{
    					no:this.no
    				}
    			}).then(response=>{
    				console.log(response.data)
    				this.vo=response.data
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		},
    		methods:{
    			
    		}
    	}).mount('#detailApp')
    </script>
</body>
</html>