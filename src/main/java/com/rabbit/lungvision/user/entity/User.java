package com.rabbit.lungvision.user.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String status;

}
