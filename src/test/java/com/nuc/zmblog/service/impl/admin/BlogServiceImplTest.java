package com.nuc.zmblog.service.impl.admin;

import com.nuc.zmblog.exception.NotFoundException;
import com.nuc.zmblog.request.BlogReq;
import com.nuc.zmblog.service.admin.BlogService;
import com.nuc.zmblog.service.admin.TagsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;



@SpringBootTest
class BlogServiceImplTest {

    @Resource
    private TagsService tagsService;


    @Resource
    private BlogService blogService;

    @Test
    public void saveTest() {
        System.out.println(blogService.getBlogById(14527046881251328L));
    }

    @Test
    public  void listBlogTest() {
//       模拟组合查询
        System.out.println(blogService.listBlog(1, 10, null));

    }



}