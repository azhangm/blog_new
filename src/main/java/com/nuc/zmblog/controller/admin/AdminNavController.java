package com.nuc.zmblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 管理导航控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
@RequestMapping("/admin")
public class AdminNavController {




    @GetMapping("/addType")
    public String addType() {
        return "admin/types-input";
    }
}
