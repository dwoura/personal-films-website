package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OssMovieinfo;

/**
 * 电影资源管理Service接口
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public interface IOssMovieinfoService 
{
    /**
     * 查询电影资源管理
     * 
     * @param movieId 电影资源管理主键
     * @return 电影资源管理
     */
    public OssMovieinfo selectOssMovieinfoByMovieId(Long movieId);

    /**
     * 按类型查询电影资源
     *
     * @param typeId 分类管理主键
     * @return 分类管理
     */
    public List<OssMovieinfo> selectOssMovieinfoByTypeId(Long typeId);

    /**
     * 按年份查询电影资源
     *
     * @param year 分类管理主键
     * @return 分类管理
     */
    public List<OssMovieinfo> selectOssMovieinfoByYear(String year);

    /**
     * 按备注1查询电影资源
     *
     * @param bak1 分类管理主键
     * @return 分类管理
     */
    public List<OssMovieinfo> selectOssMovieinfoByBak1(String bak1);
    /**
     * 查询电影资源管理列表
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 电影资源管理集合
     */
    public List<OssMovieinfo> selectOssMovieinfoList(OssMovieinfo ossMovieinfo);

    /**
     * 新增电影资源管理
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 结果
     */
    public int insertOssMovieinfo(OssMovieinfo ossMovieinfo);

    /**
     * 修改电影资源管理
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 结果
     */
    public int updateOssMovieinfo(OssMovieinfo ossMovieinfo);

    /**
     * 批量删除电影资源管理
     * 
     * @param movieIds 需要删除的电影资源管理主键集合
     * @return 结果
     */
    public int deleteOssMovieinfoByMovieIds(String movieIds);

    /**
     * 删除电影资源管理信息
     * 
     * @param movieId 电影资源管理主键
     * @return 结果
     */
    public int deleteOssMovieinfoByMovieId(Long movieId);


}
