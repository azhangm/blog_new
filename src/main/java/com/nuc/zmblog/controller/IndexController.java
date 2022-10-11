package com.nuc.zmblog.controller;

import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.service.admin.TypeService;
import org.springframework.stereotype.Controller;
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
@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagsService tagsService;

    /**
     * 指数
     *
     * @param page  页面
     * @param model 模型
     * @return {@link String}
     */
    @GetMapping("/")
    public String index( @RequestParam(required = false) Integer page, Model model) {
        page = page == null ? 1 : page;
        PageResp<BlogResp> blogRespPageResp = blogService.listBlog(page, 5, null);
//        System.out.println(blogService.countBlog());
        model.addAttribute("count",blogService.countBlog());
        model.addAttribute("page",blogRespPageResp);
        model.addAttribute("types",typeService.listType(5));
        model.addAttribute("tags",tagsService.listTags(6));
        model.addAttribute("recommend",blogService.listRecommendByCreateTime(5));
        return "index";
    }

    
}
