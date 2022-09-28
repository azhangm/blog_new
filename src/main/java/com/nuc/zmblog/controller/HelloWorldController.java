package com.nuc.zmblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hello world控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping("/blog")
    public String hello () {
        System.out.println("方法执行了");
        return "blog";
    }

}
