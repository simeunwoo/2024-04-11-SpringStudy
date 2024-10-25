<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.page-link:hover{
		cursor: pointer;
}
	.logoimgs{
		width: 45px;
		height: 45px;
		margin-right:45px;
		margin-left: 45px;
		margin: 15px;
	}
</style>
</head>
<body>

<div id="listApp">
<!-- ���� -->
<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-16">
                <div class="bradcumb-title text-center">
                    <h2 style="font-size: 50px;">�� ��</h2>
                </div>
            </div>
        </div>
    </div>
</div>
 <div class="breadcumb-nav" style="margin-bottom: 50px;">
    <div class="container">
        <div class="row">
            <div class="col-12">
				<div class="text-center" style="margin-left: 15px; margin-right: 15px; ">
				    <input type="image" src="../images/logo/doosan.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind1()">
                    <input type="image" src="../images/logo/LG.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind2()">
                    <input type="image" src="../images/logo/kt.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind3()">
                    <input type="image" src="../images/logo/kia.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind4()">
                    <input type="image" src="../images/logo/ssg.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind5()">
                    <input type="image" src="../images/logo/samsung.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind6()">
                    <input type="image" src="../images/logo/hanhwa.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind7()">
                    <input type="image" src="../images/logo/lotte.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind8()">
                    <input type="image" src="../images/logo/nc.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind9()">
                    <input type="image" src="../images/logo/kiwoom.png" class="logoimgs" value="Ŭ��" @click="kboGoodsFind10()">
					</br>
					<p class="" style="color: #b2b7a8; margin-left: 45px; ">�ΰ� Ŭ���ϸ� �ش� ���� �˻��˴ϴ�.</p>
               	</div>
               	<div class="text-right">
               		<input type="image" src="../images/reset.png" style="width: 25px; margin-right: 10px;" @click="kboGoodsFindReset()">
               		<input type=text style="color: black; text-transform: uppercase;" size=35 ref="fd" v-model="fd" @keydown.enter="kboGoodsFind()">&nbsp;
                   	<input type="button" src="" class=""  value="�˻�" @click="kboGoodsFind()">
				</div>	
            </div>
        </div>
    </div>
</div>

<section class="archive-area section_padding_80">
<div class="container">
    <div class="row">
        <!-- Single Post -->
        <div class="col-16 col-md-6 col-lg-4" v-for="vo in kboGoods_list" style="margin-bottom: 50px;">
            <div class="single-post wow fadeInUp" data-wow-delay="0.1s"style="height: 300px;">
                <!-- Post Thumb -->
                <div class="text-center">
                   <a :href="'../kboGoods/detail_before.do?gno='+vo.gno">
                    <img :src="vo.poster" style="width: 250px; height: 250px;">
                   </a>
                </div>
                <!-- Post Content -->
                <div class="post-content">
                   <a :href="'../kboGoods/detail_before.do?gno='+vo.gno">
                       <h4 style=" font-size: 100%;">{{vo.name}}</h4>
                   </a>	
               </div>
               <div class="kbogoods_price" >
               		<a :href="'../kboGoods/detail_before.do?gno='+vo.gno" style="color:#888;">{{vo.price}}</a>
               </div>
           </div>
       </div>
	</div>
</div>
</section>
            

       <div class="col-16">
           <div class="pagination-area d-sm-flex mt-15  text-center">
               <nav aria-label="#">
                   <ul class="pagination">
                       <li class="page-item" v-if="startPage>1">
                           <a class="page-link" @click="prev()"><i class="fa fa-angle-double-left" aria-hidden="true"></i> ����</a>
                       </li>
                       
                       <li :class="i===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)">
                           <a class="page-link" @click="pageChange(i)">{{i}}</a>
                       </li>
            
                       <li class="page-item" v-if="endPage<totalpage">
                           <a class="page-link" @click="next()">���� <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                       </li>
                   </ul>
               </nav>
               <div class="page-status">
                   <p>{{curpage}} page / {{totalpage}} pages</p>
               </div>
           </div>
       </div>

</div>




<script>
	let listApp=Vue.createApp({
	 data(){
		 return {
			 kboGoods_list:[],
			 curpage:1,
			 totalpage:0,
			 startPage:0,
			 endPage:0,
			 fd:'',
			 fd2:''
		 }
	 },
	 mounted(){
		 this.dataRecv()
	 },
	 // ����� ���� �Լ� => �̺�Ʈ ó�� , �������� ���� 
	 methods:{
		 kboGoodsFindReset(){
			this.fd=''
			this.fd2=''
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind(){
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind1(){
			this.fd2='�λ꺣�'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind2(){
			this.fd2='LG'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind3(){
			this.fd2='KT����'
			this.curpage=1
			this.dataRecv()
		},
		kboGoodsFind4(){
			this.fd2='KIAŸ�̰���'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind5(){
			this.fd2='SSG������'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind6(){
			this.fd2='�Ｚ���̿���'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind7(){
			this.fd2='��ȭ�̱۽�'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind8(){
			this.fd2='�Ե����̾���'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind9(){
			this.fd2='NC���̳뽺'
			this.curpage=1
			this.dataRecv()
		 },
		 kboGoodsFind10(){
			this.fd2='Ű���������'
			this.curpage=1
			this.dataRecv()
		 },
		 prev(){
			 this.curpage=this.startPage-1
			 this.dataRecv()
		 },
		 next(){
			 this.curpage=this.endPage+1
			 this.dataRecv()
		 },
		 pageChange(page){
			 this.curpage=page
			 this.dataRecv()
		 },
		 range(start,end){
			 let arr=[]
			 let len=end-start
			 for(let i=0;i<=len;i++)
			 {
				 arr[i]=start
				 start++
			 }
			 return arr
		 },
		 
		 // �������� ���Ǵ� �Լ� => ���������Ŀ� ������ �б�
		 dataRecv(){
			 axios.get('../kboGoods/find_vue.do',{
				 params:{
					 page:this.curpage,
					 fd:this.fd,
					 fd2:this.fd2
				 }
			 }).then(response=>{
				 // ���� ����� => �����͸� �о�´� 
				 console.log(response.data)
				 this.kboGoods_list=response.data.list
				 this.curpage=response.data.curpage
				 this.totalpage=response.data.totalpage
				 this.startPage=response.data.startPage
				 this.endPage=response.data.endPage
			 }).catch(error=>{
				 // �������� ���� �߻�
				 alert(error.response)
				 console.log(error.response)
			 })
		 }
	 }
	}).mount('#listApp')
</script>
    
</body>
</html>