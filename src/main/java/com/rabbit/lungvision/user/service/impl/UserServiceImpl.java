package com.rabbit.lungvision.user.service.impl;

import com.rabbit.lungvision.user.entity.User;
import com.rabbit.lungvision.user.mapper.UserMapper;
import com.rabbit.lungvision.user.service.UserService;
import com.rabbit.lungvision.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int login(String username, String password) {
        String pwdByMd5 = MD5Utils.calculateMD5(password);
        List<User> users = userMapper.queryByUserNameAndPassword(username, pwdByMd5);
        Optional<User> user = users.stream().findFirst();
        return user.map(User::getId).orElse(-1);
    }

}
