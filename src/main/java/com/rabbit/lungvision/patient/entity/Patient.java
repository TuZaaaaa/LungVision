package com.rabbit.lungvision.patient.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
