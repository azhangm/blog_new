package com.nuc.zmblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 导航控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
public class NavController {

    @GetMapping("/blogTags")
    public String blogTags() {
        return "tags";
    }

    @GetMapping("/blog")
    public String blog() {
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
