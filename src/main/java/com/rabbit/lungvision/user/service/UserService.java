package com.rabbit.lungvision.user.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int login(String username, String password);
}
