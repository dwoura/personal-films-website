package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OssTypeMapper;
import com.ruoyi.system.domain.OssType;
import com.ruoyi.system.service.IOssTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分类管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Service
public class OssTypeServiceImpl implements IOssTypeService 
{
    @Autowired
    private OssTypeMapper ossTypeMapper;

    /**
     * 查询分类管理
     * 
     * @param typeId 分类管理主键
     * @return 分类管理
     */
    @Override
    public OssType selectOssTypeByTypeId(Long typeId)
    {
        return ossTypeMapper.selectOssTypeByTypeId(typeId);
    }

    /**
     * 查询分类管理列表
     * 
     * @param ossType 分类管理
     * @return 分类管理
     */
    @Override
    public List<OssType> selectOssTypeList(OssType ossType)
    {
        return ossTypeMapper.selectOssTypeList(ossType);
    }

    /**
     * 新增分类管理
     * 
     * @param ossType 分类管理
     * @return 结果
     */
    @Override
    public int insertOssType(OssType ossType)
    {
        ossType.setCreateTime(DateUtils.getNowDate());
        return ossTypeMapper.insertOssType(ossType);
    }

    /**
     * 修改分类管理
     * 
     * @param ossType 分类管理
     * @return 结果
     */
    @Override
    public int updateOssType(OssType ossType)
    {
        ossType.setUpdateTime(DateUtils.getNowDate());
        return ossTypeMapper.updateOssType(ossType);
    }

    /**
     * 批量删除分类管理
     * 
     * @param typeIds 需要删除的分类管理主键
     * @return 结果
     */
    @Override
    public int deleteOssTypeByTypeIds(String typeIds)
    {
        return ossTypeMapper.deleteOssTypeByTypeIds(Convert.toStrArray(typeIds));
    }

    /**
     * 删除分类管理信息
     * 
     * @param typeId 分类管理主键
     * @return 结果
     */
    @Override
    public int deleteOssTypeByTypeId(Long typeId)
    {
        return ossTypeMapper.deleteOssTypeByTypeId(typeId);
    }

    /**
     * 查询分类管理树列表
     * 
     * @return 所有分类管理信息
     */
    @Override
    public List<Ztree> selectOssTypeTree()
    {
        List<OssType> ossTypeList = ossTypeMapper.selectOssTypeList(new OssType());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (OssType ossType : ossTypeList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(ossType.getTypeId());
            ztree.setpId(ossType.getPid());
            ztree.setName(ossType.getTypeName());
            ztree.setTitle(ossType.getTypeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
