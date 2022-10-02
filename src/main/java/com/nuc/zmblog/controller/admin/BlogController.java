package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.service.admin.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Resource
    private TypeService typeService;

    @Resource
    private TagsService tagService;

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
        model.addAttribute("BlogPage",blogService.listBlog(page,10,blogReq));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/blogs :: blogList");
        return modelAndView;
    }

//    先不添加 user 因为数据库表设计没有增加 user 以后优化再说
    @PostMapping("/blogs-pub")
    public String blogsPub(BlogReq blogReq , RedirectAttributes attributes , @RequestParam("content-editor-markdown-doc") String content) {
        blogReq.setContent(content);

        Integer integer = blogService.saveBlog(blogReq);
        if (integer > 0) {
            attributes.addFlashAttribute("message","操作成功");
        }else attributes.addFlashAttribute("message","操作失败");

        return "admin/blogs-pub";
    }

    @GetMapping ("/blogs-pub")
    public String blogsPub(Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTags());
        System.out.println(typeService.listType());
        System.out.println(tagService.listTags());
        return "admin/blogs-pub";
    }

}
