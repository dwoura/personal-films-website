package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OssSlide;
import com.ruoyi.system.service.IOssSlideService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 幻灯片列Controller
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Controller
@RequestMapping("/system/slide")
public class OssSlideController extends BaseController
{
    private String prefix = "system/slide";

    @Autowired
    private IOssSlideService ossSlideService;

    @RequiresPermissions("system:slide:view")
    @GetMapping()
    public String slide()
    {
        return prefix + "/slide";
    }

    /**
     * 查询幻灯片列列表
     */
    @RequiresPermissions("system:slide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OssSlide ossSlide)
    {
        startPage();
        List<OssSlide> list = ossSlideService.selectOssSlideList(ossSlide);
        return getDataTable(list);
    }

    /**
     * 导出幻灯片列列表
     */
    @RequiresPermissions("system:slide:export")
    @Log(title = "幻灯片列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OssSlide ossSlide)
    {
        List<OssSlide> list = ossSlideService.selectOssSlideList(ossSlide);
        ExcelUtil<OssSlide> util = new ExcelUtil<OssSlide>(OssSlide.class);
        return util.exportExcel(list, "幻灯片列数据");
    }

    /**
     * 新增幻灯片列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存幻灯片列
     */
    @RequiresPermissions("system:slide:add")
    @Log(title = "幻灯片列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OssSlide ossSlide)
    {
        return toAjax(ossSlideService.insertOssSlide(ossSlide));
    }

    /**
     * 修改幻灯片列
     */
    @RequiresPermissions("system:slide:edit")
    @GetMapping("/edit/{slideId}")
    public String edit(@PathVariable("slideId") Long slideId, ModelMap mmap)
    {
        OssSlide ossSlide = ossSlideService.selectOssSlideBySlideId(slideId);
        mmap.put("ossSlide", ossSlide);
        return prefix + "/edit";
    }

    /**
     * 修改保存幻灯片列
     */
    @RequiresPermissions("system:slide:edit")
    @Log(title = "幻灯片列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OssSlide ossSlide)
    {
        return toAjax(ossSlideService.updateOssSlide(ossSlide));
    }

    /**
     * 删除幻灯片列
     */
    @RequiresPermissions("system:slide:remove")
    @Log(title = "幻灯片列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ossSlideService.deleteOssSlideBySlideIds(ids));
    }
}
