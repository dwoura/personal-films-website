<template>
	<view>
		<view class="detail-header">
			<!--海报部分开始-->
			<view class="cover">
				<image class="cover-img" :src="movieinfo.movieCover"></image>
			</view >
			<!--海报部分结束-->
			<!--电影详情开始-->
			<view class="detail">
				<view class="detail-entry">
					<text>影片：</text>
					<text class="detail-movie-name">{{movieinfo.movieName}}</text>
					<text class="detail-movie-common">{{movieinfo.movieRemark}}</text>
				</view>
				<view class="detail-entry">
					<text class="">导演:</text>
					<text class="detail-movie-common">{{movieinfo.movieDirector}}</text>
				</view>
				<view class="detail-entry">
					<text class="">主演:</text>
					<text class="detail-movie-common">{{movieinfo.movieActor}}</text>
				</view>
				<view class="detail-entry">
					<text class="">类型:</text>
					<text class="detail-movie-common">{{movieinfo.movieBak2}}</text>
				</view>
				<view class="detail-entry">
					<text class="">地区:</text>
					<text class="detail-movie-common">{{movieinfo.movieArea}}</text>
				</view>
				<view class="detail-entry">
					<text class="">语言:</text>
					<text class="detail-movie-common">{{movieinfo.movieLan}}</text>
				</view>
				<view class="detail-entry">
					<text class="">上映:</text>
					<text class="detail-movie-common">{{movieinfo.movieShowtime}}</text>
				</view>
				<view class="detail-entry">
					<text class="">更新:</text>
					<text class="detail-movie-common">{{movieinfo.movieUpdatetime}}</text>
				</view>
			</view>
			<!--电影详情结束-->
		</view>
		<view class="detail-content">
			<view>
				<text>剧情介绍</text>
			</view>
			<view>
				<text class="detail-content-jianjie">{{movieinfo.movieContent}}</text>
			</view>
			<view class="detail-playList">
				<view class="detail-playList-bar">
					<text class="detail-playList-bar-btn" @tap="handler(1)">播放列表1</text>
					<text class="detail-playList-bar-btn" @tap="handler(2)">播放列表2</text>
				</view>
				<view class="detail-playList-content-bar" v-show="playListShow==1">
					<view  v-for="(item,index) in urlList1" :key="index" class="detail-playList-content-bar-btn1">
						<navigator open-type="navigate" :url="'/pages/play/play?playUrl='+encodeURIComponent(item)">
							<text>{{Episode1[index]}}</text>
						</navigator>
					</view>
				</view>
				<view class="detail-playList-content-bar" v-show="playListShow==2">
					<view  v-for="(item,index) in urlList2" class="detail-playList-content-bar-btn2">
						<navigator open-type="navigate" :url="'/pages/play/play?playUrl='+encodeURIComponent(item)">
							<text>{{Episode2[index]}}</text>
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
				playListShow:1 ,
				movieinfo:{
					movieId:1,
					movieName:'',
					movieDirector:'',
					movieCover:'',
					movieActor:'',
					movieArea:'',
					movieLan:'',
					movieShowtime:'',
					movieUpdatetime:'',
					movieContent:'',
					movieRemark:'',
					movieBak2:'',
					moviePlaylist1:[],
					moviePlaylist2:[]
				},
				urlList1:[],
				urlList2:[],
				Episode1:[],
				Episode2:[],
				urllist:[]
			}
		},
		methods: {
			handler:function(tag){
				this.playListShow=tag;
			},
		},
		onLoad:function(option) {
			let mid=option.mid;
			uni.request({
				url:'http://localhost/remote/getMovieByMid',
				data:{
					mid:mid
				},
				success: (res) => {
					console.log(res.data.data);
					this.movieinfo=res.data.data;
					this.urllist=this.movieinfo.moviePlaylist1.split('\r\n');
					for (let i in this.urllist) {
						this.Episode1.push(this.urllist[i].split('$')[0]);
						this.urlList1.push(this.urllist[i].split('$')[1]);
					}
					this.urlList1.pop();
					this.urllist=this.movieinfo.moviePlaylist2.split('\r\n');
					for (let i in this.urllist) {
						this.Episode2.push(this.urllist[i].split('$')[0]);
						this.urlList2.push(this.urllist[i].split('$')[1]);
					}
					this.urlList2.pop();
				}
			})
		}
	}
</script>

<style>
.detail-header{
	display: flex;
	justify-content: space-around;
	padding: 10rpx;
	height: 480rpx;
}
.cover{
	width: 360rpx;
}
.cover-img{
	margin-top: 16rpx;
	width: 350rpx;
	border-radius: 10rpx;
}
.detail{
	width:360rpx;
	margin-left: 10rpx;
}
.detail-content{
	padding: 10rpx;
}
.detail-content-jianjie{
	font-size: 14rpx;
}
.detail-playList{
	padding: 10rpx;
}
.detail-playList-bar{
	display: flex;
	margin-bottom: 30rpx;
}
.detail-playList-bar-btn{
	display: inline-block;
	text-align: center;
	width: 200rpx;
	background-color: tomato;
	height: 50rpx;
	line-height: 50rpx;
	border-radius: 15rpx;
	margin: 0 10rpx;
}
.detail-playList-content-bar{
	width: 100%;
}
.detail-playList-content-bar-btn1{
	font-size: 14rpx;
	display: inline-block;
	text-align: center;
	width: 115rpx;
	background-color: skyblue;
	height: 40rpx;
	line-height: 40rpx;
	border-radius: 15rpx;
	margin: 10rpx 10rpx 10rpx 10rpx;
}
.detail-playList-content-bar-btn2{
	font-size: 14rpx;
	display: inline-block;
	text-align: center;
	width: 115rpx;
	background-color: lightblue;
	height: 40rpx;
	line-height: 40rpx;
	border-radius: 15rpx;
	margin: 10rpx 10rpx 10rpx 10rpx;
}
.detail-movie-name{

}
.detail-movie-common{
	font-size: 18rpx;
	margin-left: 20rpx;
}
.detail-entry{
	margin: 10rpx 0rpx 10rpx 0rpx;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 2;
	overflow-y: hidden;
}
</style>
