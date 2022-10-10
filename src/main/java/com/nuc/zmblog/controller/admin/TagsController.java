package com.nuc.zmblog.controller.admin;
import com.nuc.zmblog.request.TagsReq;
import com.nuc.zmblog.service.admin.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 型控制器
 *
 * @author 74282
 * @date 2022/10/9
 */
@Controller
@RequestMapping("/admin/tags")
public class TagsController {

    @Resource
    private TagsService tagService;

    @GetMapping
    public ModelAndView tags (@RequestParam(required = false) Integer page , Model model , ModelAndView modelAndView
    ) {
        page = page == null ? 1 : page;
        model.addAttribute("page",tagService.listTag(page,10));
        System.out.println(model.getAttribute("page"));
        modelAndView.setViewName("admin/tags");
        return modelAndView;
    }


    @PostMapping("/addTag/")
//    Valid ---> 参数验证
    public String save(@Valid TagsReq req ,
//                       接收校验之后的结果
                       BindingResult result,
                       RedirectAttributes attributes,
                       HttpSession session
                       ) {
        if (result.hasErrors()) {
            return "redirect:/admin/addTag";
        }
        Long id = (Long) session.getAttribute("id");
        session.removeAttribute("id");
        req.setId(id);
        Integer integer = tagService.saveTag(req);
        if (integer > 0) {
            attributes.addFlashAttribute("message","操作成功");
        }else attributes.addFlashAttribute("message","操作失败");

        return "redirect:/admin/tags";
    }

    /**
     * 删除
     *
     * @return {@code String}
     */
    @GetMapping("/delete")
    public String delete(@RequestParam Long id , RedirectAttributes attributes) {
        int i = tagService.removeById(id);
        if (i <= 0 ) {
            attributes.addFlashAttribute("message","删除失败");
        }else attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/tags";
    }

    /**
     * 更新
     *
     * @return {@code String}
     */
    @GetMapping ("/update/")
    public String update(@RequestParam Long id , HttpSession session) {
        session.setAttribute("id",id);
        return "forward:/admin/addTag/";
    }
}
