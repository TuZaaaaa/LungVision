package com.rabbit.lungvision.dashboard.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.dashboard.entity.ImageProcessChart;
import com.rabbit.lungvision.dashboard.entity.PanelGroup;
import com.rabbit.lungvision.dashboard.entity.PatientAgeChart;
import com.rabbit.lungvision.dashboard.mapper.DashboardMapper;
import com.rabbit.lungvision.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    DashboardMapper dashboardMapper;


    @Override
    public Result<PanelGroup> getPanelGroup() {
        return Result.success(dashboardMapper.getPanelGroup());
    }

    @Override
    public Result<PatientAgeChart> patientAgeChart() {
        PatientAgeChart patientAgeChart = dashboardMapper.getPatientAgeChart();
        return Result.success(patientAgeChart);
    }

    @Override
    public Result<List<ImageProcessChart>> imageProcessingChart() {
        List<ImageProcessChart> imageProcessingChart = dashboardMapper.getImageProcessingChart();
        return Result.success(imageProcessingChart);
    }
}
