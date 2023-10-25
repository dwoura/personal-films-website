package com.ruoyi.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.json.JSON;
import com.ruoyi.system.domain.OssMovieinfo;
import com.ruoyi.system.domain.OssSlide;
import com.ruoyi.system.domain.OssType;
import com.ruoyi.system.service.IOssMovieinfoService;
import com.ruoyi.system.service.IOssSlideService;
import com.ruoyi.system.service.IOssTypeService;
import com.ruoyi.system.util.ApiRestResponse;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.ruoyi.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/remote")
public class RemoteController {
    @Autowired
    private IOssSlideService ossSlideService;

    @Autowired
    private IOssMovieinfoService ossMovieinfoService;

    @Autowired
    private IOssTypeService ossTypeService;

    //返回幻灯片信息给前台
    @CrossOrigin
    @RequestMapping("/getSlideList")
    public ApiRestResponse getSlideList(){
        List<OssSlide> ossSlides = ossSlideService.selectOssSlideList(null);
        return ApiRestResponse.success(ossSlides);
    }

    //返回电影信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getMovieList")
    public ApiRestResponse getMovieList(){
        startPage();
        //添加条件 查询的都是电影
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieType2(1l);

        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回电视剧信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getTvList")
    public ApiRestResponse getTvList(){
        startPage();
        //添加条件 查询的都是电视剧
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieType2(2l);

        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回综艺信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getZongyiList")
    public ApiRestResponse getZongyiList(){
        startPage();
        //添加条件 查询的都是综艺
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieType1(3l);

        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回动漫信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getDongmanList")
    public ApiRestResponse getDongmanList(){
        startPage();
        //添加条件 查询的都是动漫
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieType1(4l);

        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回最热门电影信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getHotList")
    public ApiRestResponse getHotList(){
        startPage();
        //添加条件 查询的都是电影
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieBak1("HOT");

        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //根据关键字查询电影
    @CrossOrigin
    @RequestMapping("/searchByKeyWord")
    public ApiRestResponse searchByKeyWord(@RequestParam("keyword") String Keyword){
        if(Keyword=="" || Keyword==null)
            return ApiRestResponse.error("500","搜索关键字不能为空");
        //添加搜索条件
        OssMovieinfo ossMovieinfoParam = new OssMovieinfo();
        ossMovieinfoParam.setMovieName(Keyword);
        System.out.println("查询电影："+Keyword);
        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfoParam);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //查询一级分类
    @CrossOrigin
    @RequestMapping("/getTypeList")
    public ApiRestResponse getTypeList(){
        //查询条件
        OssType ossTypeParam=new OssType();
        ossTypeParam.setPid(0l);

        //查询一级分类
        List<OssType> ossTypes = ossTypeService.selectOssTypeList(ossTypeParam);
        return ApiRestResponse.success(ossTypes);
    }

    //查询电影类型
    @CrossOrigin
    @RequestMapping("/getMovieTypeList")
    public ApiRestResponse getMovieTypeList(){
        //查询条件
        OssType ossTypeParam=new OssType();
        ossTypeParam.setPid(1l);

        //查询一级分类
        List<OssType> ossTypes = ossTypeService.selectOssTypeList(ossTypeParam);
        return ApiRestResponse.success(ossTypes);
    }

    //查询电视剧类型
    @CrossOrigin
    @RequestMapping("/getTvTypeList")
    public ApiRestResponse getTvTypeList(){
        //查询条件
        OssType ossTypeParam=new OssType();
        ossTypeParam.setPid(2l);

        //查询二级分类
        List<OssType> ossTypes = ossTypeService.selectOssTypeList(ossTypeParam);
        return ApiRestResponse.success(ossTypes);
    }

    //查询年份列表 用于
    @CrossOrigin
    @RequestMapping("/getYearList")
    public ApiRestResponse getYearList(){
        List<Integer> yearList=new ArrayList<Integer>();
        //查询条件
        Date now=new Date();
        int year = now.getYear()+1900;
        //10表示最近十年
        for (int i = year; i >= year - 10; i--) {
            yearList.add(i);
        }
        return ApiRestResponse.success(yearList);
    }

    //返回详情信息
    //默认6条
    @CrossOrigin
    @RequestMapping("/getMovieByMid")
    public ApiRestResponse getMovieByMid(@RequestParam("mid") long mid){
        OssMovieinfo ossMovieinfos = ossMovieinfoService.selectOssMovieinfoByMovieId(mid);
        OssType ossType = ossTypeService.selectOssTypeByTypeId(ossMovieinfos.getMovieType1());
        ossMovieinfos.setMovieBak2(ossType.getTypeName());
//        if (ossType.getPid()!=0){
//            ossType=ossTypeService.selectOssTypeByTypeId(ossType.getPid());
//        }
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回指定类型电影信息
    @CrossOrigin
    @RequestMapping("/getMovieListByTypeId")
    public ApiRestResponse getMovieListByTypeId(@RequestParam("typeId") long typeId){
        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoByTypeId(typeId);
        return ApiRestResponse.success(ossMovieinfos);
    }


    //返回指定年份电影信息
    @CrossOrigin
    @RequestMapping("/getMovieListByYear")
    public ApiRestResponse getMovieListByYear(@RequestParam("year") String year){
        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoByYear(year);
        return ApiRestResponse.success(ossMovieinfos);
    }

    //返回指定备注1电影信息
    @CrossOrigin
    @RequestMapping("/getMovieListByBak1")
    public ApiRestResponse getMovieListByBak1(@RequestParam("Bak1") String bak1){
        List<OssMovieinfo> ossMovieinfos = ossMovieinfoService.selectOssMovieinfoByBak1(bak1);
        return ApiRestResponse.success(ossMovieinfos);
    }
}
