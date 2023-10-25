<template>
	<view>
		<!--幻灯片开始-->
		<swiper circular :indicator-dots="indicatorDots" :autoplay="autoplay" :interval="interval"
			:duration="duration" style="height: 400rpx;padding: 10rpx;">
			<swiper-item v-for="(item,index) in slideList" :key="index">
				<image mode="aspectFill" style="border-radius: 10rpx;width:100%;height: 360rpx;" :src="item.slideUrl"></image>
			</swiper-item>
		</swiper>
		<!--幻灯片结束-->
		
		<view style="margin-top:10rpx;">
			<text style="color: red;font-size: 28px;" class="iconfont icon-huobao super-hot"></text>
			<text>热门电影</text>
			<scroll-view scroll-x="true" style="white-space: nowrap;">
				<view style="display:flex;justify-content:space-between;padding: 12px;text-align: center;">
					<view style="margin:5rpx" v-for="(item,index) in hotList"  :key="index">
						<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
							<view>
								<image style="width:300rpx;height:400rpx;border-radius: 5px;"  mode="aspectFill"  :src="item.movieCover"></image>
							</view>
							<view>
								<text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
							</view>
						</navigator>
					</view>
				</view>
			</scroll-view>
		</view>
		<view style="margin-top:10rpx;">
			<text style="color: red;font-size: 28px;" class="iconfont icon-dianying super-hot"></text>
			<text>电影</text>
			<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;text-align: center;"> 
				<view style="margin:5rpx" v-for="(item,index) in movieList"  :key="index">
						<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
						  <view >
							  <image  style="width:220rpx;height:400rpx;border-radius: 5px;" mode="aspectFill" :src="item.movieCover"></image>
						  </view>
						  <view style="width:220rpx;"><!--flex下要定义宽度，文本才会自动换行-->
							  <text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
						  </view>
						</navigator>
				</view>
			 </view>
		</view>
		<view style="margin-top:10rpx;">
			<text style="color: red;font-size: 28px;" class="iconfont icon-dianshijuA super-hot"></text>
			<text>电视剧</text>
			<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;text-align: center;"> 
				<view style="margin:5rpx" v-for="(item,index) in tvList"  :key="index">
						<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
						  <view >
							  <image  style="width:220rpx;height:400rpx;border-radius: 5px;" mode="aspectFill" :src="item.movieCover"></image>
						  </view>
						  <view style="width:220rpx;"><!--flex下要定义宽度，文本才会自动换行-->
							  <text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
						  </view>
						</navigator>
				</view>
			 </view>
		</view>
		<view style="margin-top:10rpx;">
			<text style="color: red;font-size: 28px;" class="iconfont icon-a-tupianyihuifu-30 super-hot"></text>
			<text>综艺剧</text>
			<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;text-align: center;">
				<view style="margin:5rpx" v-for="(item,index) in zongyiList"  :key="index">
					<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
					  <view >
						  <image  style="width:220rpx;height:400rpx;border-radius: 5px;" mode="aspectFill" :src="item.movieCover"></image>
					  </view>
					  <view style="width:220rpx;"><!--flex下要定义宽度，文本才会自动换行-->
						  <text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
					  </view>
					</navigator>
				</view>
			 </view>
		</view>
		<view style="margin-top:10rpx;">
			<text style="color: red;font-size: 28px;" class="iconfont icon-dongman super-hot"></text>
			<text>动漫</text>
			<view style="display:flex;flex-wrap:wrap;justify-content:space-between;padding: 12px;text-align: center;">
				<view style="margin:5rpx" v-for="(item,index) in dongmanList"  :key="index">
					<navigator open-type="navigate" :url="'/pages/detail/detail?mid='+item.movieId">
					  <view >
						  <image  style="width:220rpx;height:400rpx;border-radius: 5px;" mode="aspectFill" :src="item.movieCover"></image>
					  </view>
					  <view style="width:220rpx;"><!--flex下要定义宽度，文本才会自动换行-->
						  <text style="white-space: normal;font-size: 30rpx;">{{item.movieName}}</text>
					  </view>
					</navigator>
				</view>
			 </view>
		</view>
		
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			
			return {
				indicatorDots:true,
				autoplay:true,
				interval:3000,
				duration:500,
				//海报数据
				covers:[],
				//幻灯片数据
				slideList:[],
				//热播电影数据
				hotList:[],
				//电影数据
				movieList:[],
				//电视剧数据
				tvList:[],
				//综艺数据
				zongyiList:[],
				//动漫数据
				dongmanList:[],
				years:[2022,2021,2020,2019,2018,2017,2016,2015,2014,2013,2012,2011],
				title: '山东农业大学'
			}
		},
		onLoad() {
			uni.request({
				url: 'http://localhost/remote/getSlideList',
				data:{
					
				},
				success: (res) => {
					this.slideList=res.data.data;
				}
			}),
			uni.request({
				url: 'http://localhost/remote/getHotList',
				data:{
					
				},
				success: (res) => {
					this.hotList=res.data.data;
				}
			}),
			uni.request({
				url: 'http://localhost/remote/getMovieList',
				data:{
					pageSize:6
				},
				success: (res) => {
					this.movieList=res.data.data;
				}
			}),
			uni.request({
				url: 'http://localhost/remote/getTvList',
				data:{
					pageSize:6
				},
				success: (res) => {
					this.tvList=res.data.data;
				}
			}),
			uni.request({
				url: 'http://localhost/remote/getZongyiList',
				data:{
					pageSize:6
				},
				success: (res) => {
					this.zongyiList=res.data.data;
				}
			}),
			uni.request({
				url: 'http://localhost/remote/getDongmanList',
				data:{
					pageSize:6
				},
				success: (res) => {
					this.dongmanList=res.data.data;
				}
			})
			
		},
		methods: {

		}
	}
</script>

<style>
	@import "@/static/font/iconfont.css";
	@import "@/static/css/all.css";
</style>
