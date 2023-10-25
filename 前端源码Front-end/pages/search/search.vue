<template>
	<view>
		<view style="display: flex;padding: 20rpx;">
			<input v-model="keyword" style="width: 580rpx;height: 50rpx;border: 1px solid red;border-radius: 12px;padding-left: 10px;" placeholder="请输入电影名称查询"/>
			<button @click="search" style="width: 120rpx;height: 50rpx;line-height: 50rpx;font-size: 14rpx;margin-left: 10rpx;">搜索</button>
		</view>
		<text style="color: red;font-size: 30px;" class="iconfont icon-dianying super-hot"></text>
		<text style="font-size: 18px;">搜索结果</text>
		<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;">
			<view style="text-align: center;margin: 5rpx;" v-for="(item,index) in searchList" :key="index">
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
				keyword:'',
				searchList:[]
			}
		},
		methods:{
			search:function(){
				uni.request({
					url:'http://localhost/remote/searchByKeyWord',
					data:{
						keyword:this.keyword
					},
					success: (res) => {
						console.log("xxx"+res.data.data);
						this.searchList=res.data.data;
						
					}
				})
			}
		}
	}
</script>

<style>
	@import "@/static/font/iconfont.css";
	@import "@/static/css/all.css";
</style>