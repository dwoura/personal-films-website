package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 分类管理对象 oss_type
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public class OssType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型主键 */
    private Long typeId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 类型级别 */
    @Excel(name = "类型级别")
    private Long typeLevel;

    /** 类型描述 */
    @Excel(name = "类型描述")
    private String typeDesc;

    /** 父类型 */
    @Excel(name = "父类型")
    private Long pid;

    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTypeLevel(Long typeLevel) 
    {
        this.typeLevel = typeLevel;
    }

    public Long getTypeLevel() 
    {
        return typeLevel;
    }
    public void setTypeDesc(String typeDesc) 
    {
        this.typeDesc = typeDesc;
    }

    public String getTypeDesc() 
    {
        return typeDesc;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("typeLevel", getTypeLevel())
            .append("typeDesc", getTypeDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("pid", getPid())
            .toString();
    }
}
