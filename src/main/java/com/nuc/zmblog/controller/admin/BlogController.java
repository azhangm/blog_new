package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.service.admin.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 博客控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(required = false) BlogReq blogReq) {
        model.addAttribute("BlogPage",blogService.listBlog(1,10,blogReq));
        return "/admin/blogs";
    }

}
