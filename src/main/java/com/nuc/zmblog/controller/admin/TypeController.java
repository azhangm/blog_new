package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.request.TypeReq;
import com.nuc.zmblog.service.admin.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 型控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping
    public ModelAndView types (@RequestParam(required = false) Integer page , Model model , ModelAndView modelAndView
    ) {
        page = page == null ? 1 : page;
        model.addAttribute("page",typeService.listType(page,10));
        System.out.println(model.getAttribute("page"));
        modelAndView.setViewName("admin/types");
        return modelAndView;
    }


    @PostMapping("/addType/")
//    Valid ---> 参数验证
    public String save(@Valid TypeReq req ,
//                       接收校验之后的结果
                       BindingResult result,
                       RedirectAttributes attributes,
                       HttpSession session
                       ) {
        if (result.hasErrors()) {
            return "redirect:/admin/addType";
        }
        System.out.println(req);
        System.out.println("=====================");
        System.out.println(session.getAttribute("id"));
        System.out.println("=====================");
        Long id = (Long) session.getAttribute("id");
        session.removeAttribute("id");
        req.setId(id);
        Integer integer = typeService.saveType(req);
        if (integer > 0) {
            attributes.addFlashAttribute("message","操作成功");
        }else attributes.addFlashAttribute("message","操作失败");

        return "redirect:/admin/types";
    }

    /**
     * 删除
     *
     * @return {@code String}
     */
    @GetMapping("/delete")
    public String delete(@RequestParam Long id , RedirectAttributes attributes) {
        int i = typeService.removeById(id);
        if (i <= 0 ) {
            attributes.addFlashAttribute("message","删除失败");
        }else attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/types";
    }

    /**
     * 更新
     *
     * @return {@code String}
     */
    @GetMapping ("/update/")
    public String update(@RequestParam Long id , HttpSession session) {
        session.setAttribute("id",id);
        return "forward:/admin/addType/";
    }
}
