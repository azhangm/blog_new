package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagsBlogMapperTest {

    @Resource
    private TagsMapper tagsMapper;

    @Resource
    private TagsBlogMapper tagsBlogMapper;
    @Test
    void selectByBlogId() {

        tagsBlogMapper.selectByBlogId(1L);
    }

    @Test
    void selectByName() {
        System.out.println(tagsMapper.selectByName("log"));
    }
}