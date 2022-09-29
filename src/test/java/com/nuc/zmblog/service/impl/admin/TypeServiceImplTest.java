package com.nuc.zmblog.service.impl.admin;

import com.nuc.zmblog.mapper.TypeMapper;
import com.nuc.zmblog.pojo.Type;
import com.nuc.zmblog.request.TypeReq;
import com.nuc.zmblog.service.admin.TypeService;
import com.nuc.zmblog.service.admin.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class TypeServiceImplTest {

    @Resource
    private TypeService typeService;

    @Resource
    private TypeMapper typeMapper;

    @Test
    void saveType() {
    }

    @Test
    void getTypeById() {
    }

    @Test
    void removeById() {
    }

    @Test
    void listType() {
//        System.out.println(typeService.listType(2, 3));
//        System.out.println(typeService);
//        System.out.println(userService);
//        System.out.println(typeMapper.selectByExample(null));
//        Type type = new Type(null,"3",null);

        System.out.println(typeService.listType());
//        System.out.println(type);
    }

    @Test
    void updateType() {
        TypeReq req = new TypeReq(14300681365753856L, "修改");
        typeService.updateType(req);
    }
}