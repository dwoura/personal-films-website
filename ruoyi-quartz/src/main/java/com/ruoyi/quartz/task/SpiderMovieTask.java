package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.system.domain.OssMovieinfo;
import com.ruoyi.system.domain.OssType;
import com.ruoyi.system.service.IOssMovieinfoService;
import com.ruoyi.system.service.IOssTypeService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SpiderMovieTask {

    public void spiderHongNiuZiYuan(Integer day,Integer page) {
            //获取bean

            IOssMovieinfoService iOssMovieinfoService = SpringUtils.getBean(IOssMovieinfoService.class);
            IOssTypeService iOssTypeService = SpringUtils.getBean(IOssTypeService.class);
            //每天凌晨2点开始爬，默认爬首页前五页
            //对比时间 获取当天时间 设置-1为昨天时间0
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            //day为n天前
            now.setDate(now.getDate() - day);
            now.setHours(0);
            now.setMinutes(0);
            now.setSeconds(0);

            for (int i = 1; i <= page; i++) {
                String website = "https://www.hongniuziyuan.com";
                //爬首页
                String webpage = "https://www.hongniuziyuan.com/index.php/index/index/page/" + i + ".html?ac=detail";
                //1.请求红牛资源网
                Connection.Response response = null;

                try {
                    response = Jsoup.connect(webpage).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //只关注响应体
                String body = response.body();
                //解析数据
                Document parse = (Document) Jsoup.parse(body);
                Elements es = parse.select("body > strong > div.xing_vb > ul > li");
                for (Element e : es) {
                    Element movieName = e.selectFirst("span.xing_vb4 > a");
                    Element movieType = e.selectFirst("span.xing_vb5");
                    Element updateTime = e.selectFirst("span.xing_vb7");//最后更新时间

                    if (movieName != null && updateTime != null && movieType != null) {

                        Date updateDate = null;
                        try {
                            updateDate = simpleDateFormat.parse(updateTime.text());
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                        //爬取在规定的时间前的内容
                        if (updateDate.before(now)) {
                            System.out.println(movieName.text());
                            String movie_href = movieName.attr("href");
                            System.out.println(updateTime.text());
                            String href = website + movie_href;
                            System.out.println(href);

                            Connection.Response detailResponse = null;
                            try {
                                detailResponse = Jsoup.connect(href).execute();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                            String detailBody = detailResponse.body();
                            Document detailParse = Jsoup.parse(detailBody);
                            //电影信息标签获取
                            Element movie_cover = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodImg > img");
                            Element movie_name = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodh > h2");
                            Element movie_remark = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodh > span");
                            Element movie_score = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodh > label");
                            Element movie_area = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(5) > span");
                            Element movie_director = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(2) > span");
                            Element movie_actor = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(3) > span");
                            Element movie_lan = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(6) > span");
                            Element movie_showtime = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(7) > span");
                            Element movie_updatetime = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(8) > span > font");
                            Element movie_updatetime1 = detailParse.selectFirst("body > strong > div.warp > div:nth-child(1) > div > div > div.vodInfo > div.vodinfobox > ul > li:nth-child(8) > span");//备用更新日期
                            Element movie_content = detailParse.selectFirst("body > strong > div.warp > div:nth-child(2) > div.vodplayinfo");

                            if(movie_updatetime == null && movie_updatetime1 !=null){
                                movie_updatetime=movie_updatetime1;
                            }


                            System.out.println(movie_cover);
                            System.out.println(movie_name);
                            System.out.println(movie_remark);
                            System.out.println(movie_score);
                            System.out.println(movie_area);
                            System.out.println(movie_director);
                            System.out.println(movie_actor);
                            System.out.println(movie_lan);
                            System.out.println(movie_showtime);
                            System.out.println(movie_updatetime);
                            System.out.println(movie_content);




                            Elements movie_playList01_a = detailParse.select("#play_1 > ul > li > a");
                            String playList01 = "";
                            for (Element movie_a : movie_playList01_a) {
                                playList01 += movie_a.text() + "\r\n";
                            }
                            //System.out.println(playList01);
                            Elements movie_playList02_a = detailParse.select("#play_2 > ul > li > a");
                            String playList02 = "";
                            for (Element movie_a : movie_playList02_a) {
                                playList02 += movie_a.text() + "\r\n";
                            }
                            //若数据库中已经存在这部资源，则更新其分集信息和备注
                            String mname = movie_name.text();
                            //查询条件开始
                            OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
                            ossMovieinfoParam.setMovieName(mname);
                            //查询条件结束
                            List<OssMovieinfo> ossMovieinfos = iOssMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
                            if (ossMovieinfos != null && ossMovieinfos.size() > 0) {
                                //数据表中已存在该数据
                                //只需要更新该数据
                                OssMovieinfo ossMovieinfo = ossMovieinfos.get(0);
                                ossMovieinfo.setRemark(movie_remark.text());
                                ossMovieinfo.setMoviePlaylist1(playList01);
                                ossMovieinfo.setMoviePlaylist1(playList02);
                                iOssMovieinfoService.updateOssMovieinfo(ossMovieinfo);
                            } else {
                                //封装movie信息
                                String type = movieType.text();
                                //  根据类型查找对应id判断是否存在pid，若存在则一起给他
                                //查询条件开始
                                OssType ossTypeParam = new OssType();
                                ossTypeParam.setTypeDesc(type);//如筛选国产剧-》国产电视剧
                                //查询条件结束
                                List<OssType> ossTypes = iOssTypeService.selectOssTypeList(ossTypeParam);
                                if (ossTypes != null && ossTypes.size() > 0) {
                                    OssType movie_type = ossTypes.get(0);
                                    OssMovieinfo ossMovieinfo = new OssMovieinfo();
                                    ossMovieinfo.setMovieType1(movie_type.getTypeId());
                                    ossMovieinfo.setMovieType2(movie_type.getPid());
                                    ossMovieinfo.setMovieCover(movie_cover.attr("src"));
                                    ossMovieinfo.setMovieName(movie_name.text());
                                    ossMovieinfo.setMovieRemark(movie_remark.text());
                                    ossMovieinfo.setMovieScore(movie_score.text());
                                    ossMovieinfo.setMovieDirector(movie_director.text());
                                    ossMovieinfo.setMovieActor(movie_actor.text());
                                    ossMovieinfo.setMovieLan(movie_lan.text());
                                    ossMovieinfo.setMovieShowtime(movie_showtime.text());
                                    ossMovieinfo.setMovieUpdatetime(movie_updatetime.text());
                                    ossMovieinfo.setMovieContent(movie_content.text());
                                    ossMovieinfo.setMovieArea(movie_area.text());
                                    ossMovieinfo.setMoviePlaylist1(playList01);
                                    ossMovieinfo.setMoviePlaylist2(playList02);
                                    iOssMovieinfoService.insertOssMovieinfo(ossMovieinfo);
                                }
                            }


                        }
                    }


                }
            }
    }
}
