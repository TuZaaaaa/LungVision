package com.rabbit.lungvision.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Study {
    private int id;
    private int patientId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp studyDate;
    private String description;
    private int pixelPSum;
    private int pixelVSum;
    private float ventilationPerfusionRatio;
    private String processStatus;
    private int fileNum;
    private float executeTime;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
}
