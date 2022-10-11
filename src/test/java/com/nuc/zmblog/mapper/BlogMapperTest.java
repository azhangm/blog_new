package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.Blog;
import com.nuc.zmblog.pojo.BlogExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMapperTest {

    @Resource
    private BlogMapper blogMapper;

    @Test
    void selectByExample() {
        System.out.println(blogMapper.selectByExample(new BlogExample()));
    }

    /**
     * 测试计数类型id
     */
    @Test
    void testCountByTypeId () {
        System.out.println(blogMapper.countByTypeId(14362175859724288L));
    }
}