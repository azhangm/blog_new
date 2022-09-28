package com.nuc.zmblog.mapper;

import com.nuc.zmblog.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class TypeMapperTest {

    @Resource
    private TypeMapper typeMapper;
    @Test
    void selectByName() {

        List<Type> types = typeMapper.selectByName("1111");
        System.out.println(types);
    }
}