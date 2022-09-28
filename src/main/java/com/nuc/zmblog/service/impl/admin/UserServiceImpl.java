package com.nuc.zmblog.service.impl.admin;

import com.nuc.zmblog.exception.BlogException;
import com.nuc.zmblog.exception.ExceptionEnum;
import com.nuc.zmblog.mapper.UserMapper;
import com.nuc.zmblog.pojo.User;
import com.nuc.zmblog.pojo.UserExample;
import com.nuc.zmblog.service.admin.UserService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmptyOrWhitespace(username)) throw new BlogException(ExceptionEnum.USERNAME_ISEMPTY);
        if (StringUtils.isEmptyOrWhitespace(password)) throw new BlogException(ExceptionEnum.PASSWORD_ISEMPTYE);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0)
        return users.get(0);
        else return null;
    }
}
