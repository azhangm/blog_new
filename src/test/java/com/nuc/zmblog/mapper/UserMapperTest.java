package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void insert() {
        User user = new User(1L,"张三","123456","hhehe","asdkdlas", LocalDateTime.now(),LocalDateTime.now());
        userMapper.insert(user);
    }
}