<template>
	<view class="page">
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap">
			<text class="all">总分类</text>
			<view class="tip">
				<text v-for="(item,index) in typeList" :key="index" @click="showMovie(item.typeId,'type')">{{item.typeName}}</text>
			</view>
			
		</scroll-view>
		
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap">
			<text class="all">全部</text>
			<view class="tip">
				<text v-for="(item,index) in tvTypeList" :key="index" @click="showMovie(item.typeId,'type')">{{item.typeName}}</text>
			</view>
			
		</scroll-view>
		
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap">
			<text class="all">全部</text>
			<view class="tip">
				<text v-for="(item,index) in movieTypeList" :key="index" @click="showMovie(item.typeId,'type')">{{item.typeName}}</text>
			</view>
			
		</scroll-view>
		
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap;">
			<text class="all">全部</text>
			<view class="tip" >
				<text v-for="(item,index) in yearList" :key="index" @click="showMovie(item,'year')">{{item}}</text>
			</view>
			
		</scroll-view>
		
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap">
			<text class="all">全部</text>
			<view class="tip">
				<text @click="showMovie('','bak1','免费')">免费</text>
				<text @click="showMovie('','bak1','VIP')">VIP</text>
			</view>
			
		</scroll-view>
		
		<scroll-view scroll-x="true" style="height: 30px;white-space: nowrap">
			<text class="all">最新上线</text>
			<view class="tip">
				<text @click="showMovie('','bak1','最多播放')">最多播放</text>
				<text @click="showMovie('','bak1','最受好评')">最受好评</text>
			</view>
			
		</scroll-view>
		
		<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;" >
			<view style="text-align: center;margin: 5rpx;" v-for="(item,index) in movieList" :key="index" v-if="isRefresh">
				<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
					<view>
						<image style="width: 220rpx;height: 300rpx;border-radius: 5px;" mode="aspectFill" :src="item.movieCover"></image>
					</view>
					<view style="width:220rpx;"><!--flex下要定义宽度，文本才会自动换行-->
						<text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
					</view>
				</navigator>
			</view>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				movieHotList:[],
				yearList:[],
				typeList:[],
				tvTypeList:[],
				movieTypeList:[],
				movieList:[],
				isRefresh:false
			}
		},
		methods:{
			updatePart:function(){
				//刷新组件
				this.isRefresh = false;
				this.$nextTick(() => {
					this.isRefresh=true;
				}
				
				)
			},
			showMovie:function(info,flag,bak){
				var requestUrl='';
				if(flag=='type'){
					requestUrl='http://localhost/remote/getMovieListByTypeId?typeId='+info;
				}
				if(flag=='year'){
					requestUrl='http://localhost/remote/getMovieListByYear?year='+info;
				}
				if(flag=='bak1'){
					requestUrl='http://localhost/remote/getMovieListByYear?bak1='+info;
				}
				uni.request({
					url:requestUrl,
					data:{
					},
					success: (res) => {
						console.log(res.data.data);
						this.movieList=res.data.data;
						this.updatePart();
					}
				})
				
			}
		},
		onLoad() {
			uni.request({
				url:'http://localhost/remote/getYearList',
				data:{
				},
				success: (res) => {
					console.log(res.data.data);
					this.yearList=res.data.data;
				}
			}),
			uni.request({
				url:'http://localhost/remote/getTypeList',
				data:{
				},
				success: (res) => {
					console.log(res.data.data);
					this.typeList=res.data.data;
				}
			}),
			uni.request({
				url:'http://localhost/remote/getMovieTypeList',
				data:{
				},
				success: (res) => {
					console.log(res.data.data);
					this.movieTypeList=res.data.data;
				}
			}),
			uni.request({
				url:'http://localhost/remote/getTvTypeList',
				data:{
				},
				success: (res) => {
					console.log(res.data.data);
					this.tvTypeList=res.data.data;
				}
			})
		}
	}
</script>

<style>
	@import "@/static/css/all.css";
	.page{
		padding: 10px;
	}
	
	.all{
		float: left;
		display: flex;
		font-size: 12px;
		width: 60px;
		height: 25px;
		background-color: whitesmoke;
		color: darkturquoise;
		border-radius: 15px;
		align-items: center;
		justify-content: center;
	}
	
	.tip text{
		display: inline-block;
		width: 60px;
		height: 30px;
		font-size: 12px;
		margin-left: 5px;
		margin-right: 5px;
		text-align: center;
	}
</style>