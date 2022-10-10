package com.nuc.zmblog.controller;

import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.PageResp;
import com.nuc.zmblog.service.admin.BlogService;
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

    @GetMapping("/")
    public String index( @RequestParam(required = false) Integer page, Model model) {
        PageResp<BlogResp> blogRespPageResp = blogService.listBlog(page, 8, null);
        model.addAttribute("page",blogRespPageResp);
        return "index";
    }

    
}
