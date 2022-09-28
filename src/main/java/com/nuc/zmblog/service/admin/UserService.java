package com.nuc.zmblog.service.admin;


import com.nuc.zmblog.pojo.User;

public interface UserService {
    User login(String username , String password);
}
