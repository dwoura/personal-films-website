package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OssMovieinfoMapper;
import com.ruoyi.system.domain.OssMovieinfo;
import com.ruoyi.system.service.IOssMovieinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 电影资源管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Service
public class OssMovieinfoServiceImpl implements IOssMovieinfoService 
{
    @Autowired
    private OssMovieinfoMapper ossMovieinfoMapper;

    /**
     * 查询电影资源管理
     * 
     * @param movieId 电影资源管理主键
     * @return 电影资源管理
     */
    @Override
    public OssMovieinfo selectOssMovieinfoByMovieId(Long movieId)
    {
        return ossMovieinfoMapper.selectOssMovieinfoByMovieId(movieId);
    }

    @Override
    public List<OssMovieinfo> selectOssMovieinfoByTypeId(Long movieType) {
        if(movieType >= 3)
            return ossMovieinfoMapper.selectOssMovieinfoByMovieType1(movieType);
        else
            return ossMovieinfoMapper.selectOssMovieinfoByMovieType2(movieType);
    }

    @Override
    public List<OssMovieinfo> selectOssMovieinfoByYear(String year) {
        return ossMovieinfoMapper.selectOssMovieinfoByMovieShowtime(year);
    }

    @Override
    public List<OssMovieinfo> selectOssMovieinfoByBak1(String bak1) {
        return ossMovieinfoMapper.selectOssMovieinfoByMovieBak1(bak1);
    }

    /**
     * 查询电影资源管理列表
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 电影资源管理
     */
    @Override
    public List<OssMovieinfo> selectOssMovieinfoList(OssMovieinfo ossMovieinfo)
    {
        return ossMovieinfoMapper.selectOssMovieinfoList(ossMovieinfo);
    }

    /**
     * 新增电影资源管理
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 结果
     */
    @Override
    public int insertOssMovieinfo(OssMovieinfo ossMovieinfo)
    {
        ossMovieinfo.setCreateTime(DateUtils.getNowDate());
        return ossMovieinfoMapper.insertOssMovieinfo(ossMovieinfo);
    }

    /**
     * 修改电影资源管理
     * 
     * @param ossMovieinfo 电影资源管理
     * @return 结果
     */
    @Override
    public int updateOssMovieinfo(OssMovieinfo ossMovieinfo)
    {
        ossMovieinfo.setUpdateTime(DateUtils.getNowDate());
        return ossMovieinfoMapper.updateOssMovieinfo(ossMovieinfo);
    }

    /**
     * 批量删除电影资源管理
     * 
     * @param movieIds 需要删除的电影资源管理主键
     * @return 结果
     */
    @Override
    public int deleteOssMovieinfoByMovieIds(String movieIds)
    {
        return ossMovieinfoMapper.deleteOssMovieinfoByMovieIds(Convert.toStrArray(movieIds));
    }

    /**
     * 删除电影资源管理信息
     * 
     * @param movieId 电影资源管理主键
     * @return 结果
     */
    @Override
    public int deleteOssMovieinfoByMovieId(Long movieId)
    {
        return ossMovieinfoMapper.deleteOssMovieinfoByMovieId(movieId);
    }

}
