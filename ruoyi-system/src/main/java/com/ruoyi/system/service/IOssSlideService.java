package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OssSlide;

/**
 * 幻灯片列Service接口
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public interface IOssSlideService 
{
    /**
     * 查询幻灯片列
     * 
     * @param slideId 幻灯片列主键
     * @return 幻灯片列
     */
    public OssSlide selectOssSlideBySlideId(Long slideId);

    /**
     * 查询幻灯片列列表
     * 
     * @param ossSlide 幻灯片列
     * @return 幻灯片列集合
     */
    public List<OssSlide> selectOssSlideList(OssSlide ossSlide);

    /**
     * 新增幻灯片列
     * 
     * @param ossSlide 幻灯片列
     * @return 结果
     */
    public int insertOssSlide(OssSlide ossSlide);

    /**
     * 修改幻灯片列
     * 
     * @param ossSlide 幻灯片列
     * @return 结果
     */
    public int updateOssSlide(OssSlide ossSlide);

    /**
     * 批量删除幻灯片列
     * 
     * @param slideIds 需要删除的幻灯片列主键集合
     * @return 结果
     */
    public int deleteOssSlideBySlideIds(String slideIds);

    /**
     * 删除幻灯片列信息
     * 
     * @param slideId 幻灯片列主键
     * @return 结果
     */
    public int deleteOssSlideBySlideId(Long slideId);
}
