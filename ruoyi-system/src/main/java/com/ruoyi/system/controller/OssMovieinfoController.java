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
import com.ruoyi.system.domain.OssMovieinfo;
import com.ruoyi.system.service.IOssMovieinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电影资源管理Controller
 * 
 * @author ruoyi
 * @date 2023-01-05
 */
@Controller
@RequestMapping("/system/movieinfo")
public class OssMovieinfoController extends BaseController
{
    private String prefix = "system/movieinfo";

    @Autowired
    private IOssMovieinfoService ossMovieinfoService;

    @RequiresPermissions("system:movieinfo:view")
    @GetMapping()
    public String movieinfo()
    {
        return prefix + "/movieinfo";
    }

    /**
     * 查询电影资源管理列表
     */
    @RequiresPermissions("system:movieinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OssMovieinfo ossMovieinfo)
    {
        startPage();
        List<OssMovieinfo> list = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfo);
        return getDataTable(list);
    }

    /**
     * 导出电影资源管理列表
     */
    @RequiresPermissions("system:movieinfo:export")
    @Log(title = "电影资源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OssMovieinfo ossMovieinfo)
    {
        List<OssMovieinfo> list = ossMovieinfoService.selectOssMovieinfoList(ossMovieinfo);
        ExcelUtil<OssMovieinfo> util = new ExcelUtil<OssMovieinfo>(OssMovieinfo.class);
        return util.exportExcel(list, "电影资源管理数据");
    }

    /**
     * 新增电影资源管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存电影资源管理
     */
    @RequiresPermissions("system:movieinfo:add")
    @Log(title = "电影资源管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OssMovieinfo ossMovieinfo)
    {
        return toAjax(ossMovieinfoService.insertOssMovieinfo(ossMovieinfo));
    }

    /**
     * 修改电影资源管理
     */
    @RequiresPermissions("system:movieinfo:edit")
    @GetMapping("/edit/{movieId}")
    public String edit(@PathVariable("movieId") Long movieId, ModelMap mmap)
    {
        OssMovieinfo ossMovieinfo = ossMovieinfoService.selectOssMovieinfoByMovieId(movieId);
        mmap.put("ossMovieinfo", ossMovieinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存电影资源管理
     */
    @RequiresPermissions("system:movieinfo:edit")
    @Log(title = "电影资源管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OssMovieinfo ossMovieinfo)
    {
        return toAjax(ossMovieinfoService.updateOssMovieinfo(ossMovieinfo));
    }

    /**
     * 删除电影资源管理
     */
    @RequiresPermissions("system:movieinfo:remove")
    @Log(title = "电影资源管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ossMovieinfoService.deleteOssMovieinfoByMovieIds(ids));
    }
}
