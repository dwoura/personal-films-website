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
import com.ruoyi.system.domain.OssType;
import com.ruoyi.system.service.IOssTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 分类管理Controller
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Controller
@RequestMapping("/system/type")
public class OssTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IOssTypeService ossTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询分类管理树列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public List<OssType> list(OssType ossType)
    {
        List<OssType> list = ossTypeService.selectOssTypeList(ossType);
        return list;
    }

    /**
     * 导出分类管理列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OssType ossType)
    {
        List<OssType> list = ossTypeService.selectOssTypeList(ossType);
        ExcelUtil<OssType> util = new ExcelUtil<OssType>(OssType.class);
        return util.exportExcel(list, "分类管理数据");
    }

    /**
     * 新增分类管理
     */
    @GetMapping(value = { "/add/{typeId}", "/add/" })
    public String add(@PathVariable(value = "typeId", required = false) Long typeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(typeId))
        {
            mmap.put("ossType", ossTypeService.selectOssTypeByTypeId(typeId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存分类管理
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "分类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OssType ossType)
    {
        return toAjax(ossTypeService.insertOssType(ossType));
    }

    /**
     * 修改分类管理
     */
    @RequiresPermissions("system:type:edit")
    @GetMapping("/edit/{typeId}")
    public String edit(@PathVariable("typeId") Long typeId, ModelMap mmap)
    {
        OssType ossType = ossTypeService.selectOssTypeByTypeId(typeId);
        mmap.put("ossType", ossType);
        return prefix + "/edit";
    }

    /**
     * 修改保存分类管理
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "分类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OssType ossType)
    {
        return toAjax(ossTypeService.updateOssType(ossType));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "分类管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{typeId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("typeId") Long typeId)
    {
        return toAjax(ossTypeService.deleteOssTypeByTypeId(typeId));
    }

    /**
     * 选择分类管理树
     */
    @GetMapping(value = { "/selectTypeTree/{typeId}", "/selectTypeTree/" })
    public String selectTypeTree(@PathVariable(value = "typeId", required = false) Long typeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(typeId))
        {
            mmap.put("ossType", ossTypeService.selectOssTypeByTypeId(typeId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载分类管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = ossTypeService.selectOssTypeTree();
        return ztrees;
    }
}
