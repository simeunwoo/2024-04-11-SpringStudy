let recipeApp=Vue.createApp({
			data(){
				return{
					recipe_list:[],
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
				dataRecv(){
					axios.get('http://localhost:8080/web/recipe/list_vue.do',{ // get : type 부분 / http:// ~ : url 부분 
						params:{ // params : data 부분
							page:this.curpage
						}
					}).then(response=>{ // ''.then(response=>' : success 부분
						// 결과값 받는 곳 => response.data
						console.log(response.data)
						this.recipe_list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
						this.endPage=response.data.endPage
					})
				}
			}
		}).mount('.container')