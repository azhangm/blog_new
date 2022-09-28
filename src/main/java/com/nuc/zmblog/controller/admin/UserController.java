package com.nuc.zmblog.controller.admin;

import com.nuc.zmblog.pojo.User;
import com.nuc.zmblog.service.admin.UserService;
import com.nuc.zmblog.utils.MyMD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes) {
        User login = userService.login(username, MyMD5Util.encrypt(password));
        if (login != null) {
            login.setPassword(null);
            session.setAttribute("user",login);
            System.out.println("登录成功！！");
            return "admin/blogs";
        }else {
            System.out.println("123");
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
