package com.nuc.zmblog.controller;


import com.nuc.zmblog.pojo.Blog;
import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.service.admin.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 导航控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
public class NavController {

    @Resource
    private BlogService blogService;

    @GetMapping("/blogTags")
    public String blogTags() {
        return "tags";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam Long id , Model model) {
        BlogResp blogById = blogService.getAndConvert(id);
        model.addAttribute("blog",blogById);
        return "blog";
    }


    @GetMapping("/blogType")
    public String blogType() {
        return "type";
    }

    @GetMapping("/blogArchive")
    public String blogArchive() {
        return "archive";
    }


}
