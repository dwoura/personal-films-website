<template>
    <view class="content">
            <div id="dplayer" style=" width: 60%;"></div>
        </view>
</template>

<script>
    //引入 hls与dplayer 用于解析播放视频 
    import Hls from 'hls.js'
    import Dplayer from 'dplayer'
import { decode } from 'querystring';
    export default {
        data() {
            return {
                movieinfo:{
				},
				playUrl:''
            }
        },
        mounted() {
            this.dp = new Dplayer({
                //播放器的一些参数
                container: document.getElementById('dplayer'),
                autoplay: false, //是否自动播放
                theme: '#FADFA3', //主题色
                loop: true,//视频是否循环播放
                lang: 'zh-cn',
                screenshot: false,//是否开启截图
                hotkey: true,//是否开启热键
                preload: 'auto',//视频是否预加载
                volume: 0.7,//默认音量
                mutex: true,//阻止多个播放器同时播放，当前播放器播放时暂停其他播放器
                video: {
                    url: this.playUrl, //视频地址
                    type: 'customHls',
                    customType: {
                        customHls: function(video, player) {
                            const hls = new Hls()  //实例化Hls  用于解析m3u8
                            hls.loadSource(video.src)
                            hls.attachMedia(video)
                        }
                    },
                },
            });
        },
		methods: {
			getPlayUrl () {
				console.log(decodeURIComponent(window.location.href));
				var url = decodeURIComponent(window.location.href)
				url=decodeURIComponent(url.split('playUrl=')[1]);
				if(url.search('.m3u8') == -1){
					url+='/index.m3u8'
				}
				this.playUrl=url;
			}
		},
        created() {
        },
		onLoad() {
			this.getPlayUrl ();
		}
    }
</script>


<style>
.content{
	display: flex;
	text-align: center;
	justify-content: center;
}
</style>