package com.nuc.zmblog.controller;

import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.service.admin.TypeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 指数控制器
 *
 * @author zm
 * @date 2022/10/10
 */
public class IndexController {

    @Resource
    private BlogService blogService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagsService tagsService;

    @GetMapping("/")
    public String index( @RequestParam(required = false) Integer page, Model model) {
        PageResp<BlogResp> blogRespPageResp = blogService.listBlog(page, 8, null);
        model.addAttribute("page",blogRespPageResp);
        model.addAttribute("types",typeService.listType(6));
        model.addAttribute("tags",tagsService.listTags(9));
        return "index";
    }

    
}
