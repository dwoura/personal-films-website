package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OssType;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 分类管理Service接口
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public interface IOssTypeService 
{
    /**
     * 查询分类管理
     * 
     * @param typeId 分类管理主键
     * @return 分类管理
     */
    public OssType selectOssTypeByTypeId(Long typeId);

    /**
     * 查询分类管理列表
     * 
     * @param ossType 分类管理
     * @return 分类管理集合
     */
    public List<OssType> selectOssTypeList(OssType ossType);

    /**
     * 新增分类管理
     * 
     * @param ossType 分类管理
     * @return 结果
     */
    public int insertOssType(OssType ossType);

    /**
     * 修改分类管理
     * 
     * @param ossType 分类管理
     * @return 结果
     */
    public int updateOssType(OssType ossType);

    /**
     * 批量删除分类管理
     * 
     * @param typeIds 需要删除的分类管理主键集合
     * @return 结果
     */
    public int deleteOssTypeByTypeIds(String typeIds);

    /**
     * 删除分类管理信息
     * 
     * @param typeId 分类管理主键
     * @return 结果
     */
    public int deleteOssTypeByTypeId(Long typeId);

    /**
     * 查询分类管理树列表
     * 
     * @return 所有分类管理信息
     */
    public List<Ztree> selectOssTypeTree();
}
