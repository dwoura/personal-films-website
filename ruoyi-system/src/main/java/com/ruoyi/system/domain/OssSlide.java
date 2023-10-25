package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 幻灯片列对象 oss_slide
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
public class OssSlide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 幻灯片主键 */
    private Long slideId;

    /** 幻灯片地址 */
    @Excel(name = "幻灯片地址")
    private String slideUrl;

    public void setSlideId(Long slideId) 
    {
        this.slideId = slideId;
    }

    public Long getSlideId() 
    {
        return slideId;
    }
    public void setSlideUrl(String slideUrl) 
    {
        this.slideUrl = slideUrl;
    }

    public String getSlideUrl() 
    {
        return slideUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("slideId", getSlideId())
            .append("slideUrl", getSlideUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
