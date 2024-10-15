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
                        <h2>상품 상세보기</h2>
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

                        <!-- Single Post -->
                        <div class="col-12 col-sm-12">
                        	<table class="table">
                        		<tr>
                        			<td width="30%" class="text-center" rowspan="5">
                        				<img :src="detail_data.goods_poster" style="width:100%">
                        			</td>
                        			<td colspan="2">
                        				<h4>{{detail_data.goods_name}}</h4>
                        			</td>
                        		</tr>
                        	</table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
    	let detailApp=Vue.createApp({
    		data(){
    			return{
    				detail_data:{},
    				no:${no}
    			}
    		},
    		mounted(){
    			axios.get('../goods/detail_vue.do',{
    				params:{
    					no:this.no
    				}
    			}).then(response=>{
    				console.log(response.data)
    				this.detail_data=response.data
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		},
    		methods:{
    			// 1) 구매창
    			// 2) 장바구니 => 0
    			// 3) 구매 => spring_cart : 1
    			// => mypage로 이동
    			// 4) 구매 / 장바구니 : 취소
    		}
    	}).mount('#detailApp')
    </script>
</body>
</html>