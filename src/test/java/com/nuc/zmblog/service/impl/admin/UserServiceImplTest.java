package com.nuc.zmblog.service.impl.admin;

import com.nuc.zmblog.pojo.User;
import com.nuc.zmblog.service.admin.UserService;
import com.nuc.zmblog.utils.MyMD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.provider.MD5;

import javax.annotation.Resource;


@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void login() {
        String md5 = MyMD5Util.getMD5("123456");

        User user = userService.login("张三", md5);
        System.out.println(user.getCreateTime());
    }
}