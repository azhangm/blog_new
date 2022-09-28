package com.nuc.zmblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 关于我控制器
 *
 * @author 74282
 * @date 2022/09/27
 */
@Controller
public class AboutMeController {

    @GetMapping("/aboutMe")
    public String aboutMe() {
        return "aboutMe";
    }
}
