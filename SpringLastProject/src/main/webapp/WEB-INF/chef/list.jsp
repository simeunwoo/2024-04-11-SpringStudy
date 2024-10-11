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
                        <h2>셰프 목록</h2>
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
    <section class="single_blog_area section_padding_80" id="listApp">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                	<table class="table">
                		<tr>
                			<td>
                				<table class="table" v-for="vo in chef_list">
                					<tr>
                						<td width="30%" class="text-center" rowspan="2">
                							<img :src="vo.poster" style="width:120px;height:120px" class="img-circle">
                						</td>
                						<td colspan="4">
                							<h3 style="color:orange">{{vo.chef}}</h3>
                						</td>
                					</tr>
                					<tr>
                						<td class="text-center"><img src="../img/icon/a1.png"></td>
                						<td class="text-center"><img src="../img/icon/a2.png"></td>
                						<td class="text-center"><img src="../img/icon/a3.png"></td>
                						<td class="text-center"><img src="../img/icon/oh.png"></td>
                					</tr>
                				</table>
                			</td>
                		</tr>
                	</table>
                </div>
                <div class="col-sm-6">
                	
                </div>
            </div>
        </div>
    </section>
    <script>
    	let chefApp=Vue.createApp({
    		data(){
    			return{
    				chef_list:[],
    				curpage:1,
    				totalpage:0,
    				startPage:0,
    				endPage:0
    			}
    		},
    		mounted(){
    			this.dataRecv()
    		},
    		methods:{
    			dataRecv(){
    				axios.get('../chef/list_vue.do',{
    					params:{
    						page:this.curpage
    					}
    				}).then(response=>{
    					console.log(response.data)
    					this.chef_list=response.data.list
    					this.curpage=response.data.curpage
    					this.totalpage=response.data.totalpage
    					this.startPage=response.data.startPage
    					this.endPage=response.data.endPage
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			}
    		},
    		components:{
    			
    		}
    	}).mount('#listApp')
    </script>
</body>
</html>