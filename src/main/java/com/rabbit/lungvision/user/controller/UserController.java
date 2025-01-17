package com.rabbit.lungvision.user.controller;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.user.dto.LoginRequest;
import com.rabbit.lungvision.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result<Integer> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        System.out.println(loginRequest);

        if (StringUtils.isBlank(username)) {
            return Result.error("用户名为空");
        }

        if (StringUtils.isBlank(password)) {
            return Result.error("密码为空");
        }

        int id = userService.login(username, password);
        if (id == -1) {
            return Result.error("用户名或密码错误");
        }

        return Result.success(id);
    }

}
