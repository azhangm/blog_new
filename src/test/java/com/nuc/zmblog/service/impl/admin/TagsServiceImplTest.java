package com.nuc.zmblog.service.impl.admin;

import com.nuc.zmblog.service.admin.TagsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagsServiceImplTest {


    @Resource
    private TagsService tagsService;

    @Test
    void saveTags() {
    }

    @Test
    void getTagsById() {
    }

    @Test
    void removeById() {
    }

    @Test
    void updateTags() {
    }

    @Test
    void listTags() {
    }

    @Test
    void testListTags() {
    }

    @Test
    void testListTags1() {

        System.out.println(tagsService);
        System.out.println(tagsService.listTags("1,3,4"));
    }

    @Test
    void listTagsByBlogId() {
        tagsService.listTagsByBlogId(1L);
    }
}