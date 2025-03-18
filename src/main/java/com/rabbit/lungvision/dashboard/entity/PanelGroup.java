package com.rabbit.lungvision.dashboard.entity;

import lombok.Data;

@Data
public class PanelGroup {
    private int patientCount;
    private int studyCount;
    private int taskCount;
    private float patientIncrease;
    private float studyIncrease;
    private float taskIncrease;
}
