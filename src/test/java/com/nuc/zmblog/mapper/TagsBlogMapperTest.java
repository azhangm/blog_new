package com.nuc.zmblog.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagsBlogMapperTest {


    @Resource
    private TagsBlogMapper tagsBlogMapper;
    @Test
    void selectByBlogId() {

        tagsBlogMapper.selectByBlogId(1L);
    }
}