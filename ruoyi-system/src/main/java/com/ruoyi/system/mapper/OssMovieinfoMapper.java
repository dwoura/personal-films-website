package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OssMovieinfo;

/**
 * 电影资源管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public interface OssMovieinfoMapper 
{
    /**
     * 查询电影资源管理
     * 
     * @param movieId 电影资源管理主键
     * @return 电影资源管理
     */
    public OssMovieinfo selectOssMovieinfoByMovieId(Long movieId);

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
     * 删除电影资源管理
     * 
     * @param movieId 电影资源管理主键
     * @return 结果
     */
    public int deleteOssMovieinfoByMovieId(Long movieId);

    /**
     * 批量删除电影资源管理
     * 
     * @param movieIds 需要删除的数据主键集合
     * @return 结果
     */

    public int deleteOssMovieinfoByMovieIds(String[] movieIds);


    public List<OssMovieinfo> selectOssMovieinfoByMovieType1(Long movieType1);

    public List<OssMovieinfo> selectOssMovieinfoByMovieType2(Long movieType2);

    public List<OssMovieinfo> selectOssMovieinfoByMovieShowtime(String movieShowtime);

    public List<OssMovieinfo> selectOssMovieinfoByMovieBak1(String bak1);
}
