package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TypeService;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.logging.Logger;

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

    @Resource
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(required = false) BlogReq blogReq , @RequestParam(required = false) Integer page) {
        page = page == null ? 1  : page;
        System.out.println(blogReq);
        model.addAttribute("types",typeService.listType());
        model.addAttribute("BlogPage",blogService.listBlog(page,10,blogReq));
        return "/admin/blogs";
    }

    /**
     * 博客搜索
     *
     * @param model   模型
     * @param blogReq 博客申请
     * @param page    页面
     * @return {@link String}
     */
    @PostMapping("/blogs/search")
    public ModelAndView blogsSearch(Model model, BlogReq blogReq , @RequestParam(required = false) Integer page) {
        page = page == null ? 1  : page;
        System.out.println("============= 搜索方法 ====================");
        System.out.println(blogReq);
        System.out.println("============= 搜索方法 ====================");
        model.addAttribute("BlogPage",blogService.listBlog(page,10,blogReq));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/blogs :: blogList");
        return modelAndView;
    }
}
