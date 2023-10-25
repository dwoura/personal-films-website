package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OssSlideMapper;
import com.ruoyi.system.domain.OssSlide;
import com.ruoyi.system.service.IOssSlideService;
import com.ruoyi.common.core.text.Convert;

/**
 * 幻灯片列Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Service
public class OssSlideServiceImpl implements IOssSlideService 
{
    @Autowired
    private OssSlideMapper ossSlideMapper;

    /**
     * 查询幻灯片列
     * 
     * @param slideId 幻灯片列主键
     * @return 幻灯片列
     */
    @Override
    public OssSlide selectOssSlideBySlideId(Long slideId)
    {
        return ossSlideMapper.selectOssSlideBySlideId(slideId);
    }

    /**
     * 查询幻灯片列列表
     * 
     * @param ossSlide 幻灯片列
     * @return 幻灯片列
     */
    @Override
    public List<OssSlide> selectOssSlideList(OssSlide ossSlide)
    {
        return ossSlideMapper.selectOssSlideList(ossSlide);
    }

    /**
     * 新增幻灯片列
     * 
     * @param ossSlide 幻灯片列
     * @return 结果
     */
    @Override
    public int insertOssSlide(OssSlide ossSlide)
    {
        ossSlide.setCreateTime(DateUtils.getNowDate());
        return ossSlideMapper.insertOssSlide(ossSlide);
    }

    /**
     * 修改幻灯片列
     * 
     * @param ossSlide 幻灯片列
     * @return 结果
     */
    @Override
    public int updateOssSlide(OssSlide ossSlide)
    {
        ossSlide.setUpdateTime(DateUtils.getNowDate());
        return ossSlideMapper.updateOssSlide(ossSlide);
    }

    /**
     * 批量删除幻灯片列
     * 
     * @param slideIds 需要删除的幻灯片列主键
     * @return 结果
     */
    @Override
    public int deleteOssSlideBySlideIds(String slideIds)
    {
        return ossSlideMapper.deleteOssSlideBySlideIds(Convert.toStrArray(slideIds));
    }

    /**
     * 删除幻灯片列信息
     * 
     * @param slideId 幻灯片列主键
     * @return 结果
     */
    @Override
    public int deleteOssSlideBySlideId(Long slideId)
    {
        return ossSlideMapper.deleteOssSlideBySlideId(slideId);
    }
}
