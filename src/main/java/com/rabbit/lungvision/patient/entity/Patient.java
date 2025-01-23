package com.rabbit.lungvision.patient.entity;

import lombok.Data;

@Data
public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String status;
}
