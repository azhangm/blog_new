package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.exception.NotFoundException;
import com.nuc.zmblog.pojo.Blog;
import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.resp.BlogResp;
import com.nuc.zmblog.resp.TagsResp;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import com.nuc.zmblog.service.admin.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("types",typeService.listType());
        model.addAttribute("BlogPage",blogService.listBlog(page,10,blogReq));
        return "admin/blogs";
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
    @PostMapping("/blogs")
    public String blogsPub(BlogReq blogReq ,
                           RedirectAttributes attributes ,
                           HttpSession session,
                           @RequestParam("content-editor-markdown-doc") String content
            ) {
        Long id = (Long) session.getAttribute("id");
        if (id != null) {
            blogReq.setId(id);
            session.removeAttribute("id");
        }
        blogReq.setContent(content);
        blogReq.setPublished(true);
        Integer integer = blogService.saveBlog(blogReq);

        if (integer > 0) {
            attributes.addFlashAttribute("message","操作成功");
        }else attributes.addFlashAttribute("message","操作失败");

        return "redirect:blogs";
    }

    @GetMapping ("/blogs-pub")
    public String blogsPub(Model model) {
        setTypeAndTag(model);

        if (model.getAttribute("blog") == null)
        model.addAttribute("blog",new BlogResp());
        return "admin/blogs-pub";
    }


    @GetMapping("/blogs/delete")
    public String deleteBlog(@RequestParam Long id , RedirectAttributes attributes ) {
        int i = blogService.removeById(id);
        if (i > 0) {
            attributes.addFlashAttribute("message","操作成功");
        }else attributes.addFlashAttribute("message","操作失败");

        return "redirect:";

    }


    @GetMapping("/blogs-edit")
    public String editBlog(@RequestParam Long id , Model model, HttpSession session) {
        setTypeAndTag(model);
        BlogResp blogById = blogService.getBlogById(id);
        if (blogById == null) throw new NotFoundException("没有该博客");
        List<TagsResp> list = tagService.listTagsByBlogId(id);
        System.out.println(list);
        StringBuffer sb = new StringBuffer();
        for (TagsResp tagsResp : list) {
                sb.append(tagsResp.getId());
                sb.append(",");
        }
        System.out.println(sb.toString());
        String tagsId = sb.substring(0, sb.length() - 1);
        blogById.setTagIds(tagsId);
        System.out.println("=================edit====================");
        System.out.println(blogById);
        System.out.println("=================edit====================");
        session.setAttribute("id",id);
        model.addAttribute("blog",blogById);
        return "admin/blogs-pub";
    }

    private void setTypeAndTag(Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTags());
    }
}
