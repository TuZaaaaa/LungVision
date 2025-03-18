package com.rabbit.lungvision.dashboard.service;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.dashboard.entity.ImageProcessChart;
import com.rabbit.lungvision.dashboard.entity.PanelGroup;
import com.rabbit.lungvision.dashboard.entity.PatientAgeChart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashboardService {

    Result<PanelGroup> getPanelGroup();

    Result<PatientAgeChart> patientAgeChart();

    Result<List<ImageProcessChart>> imageProcessingChart();

}
