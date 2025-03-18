package com.rabbit.lungvision.dashboard.controller;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.dashboard.entity.ImageProcessChart;
import com.rabbit.lungvision.dashboard.entity.PanelGroup;
import com.rabbit.lungvision.dashboard.entity.PatientAgeChart;
import com.rabbit.lungvision.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PostMapping("/panelGroup")
    public Result<PanelGroup> panelGroup() {
        return dashboardService.getPanelGroup();
    }

    @PostMapping("/patientAgeChart")
    public Result<PatientAgeChart> patientAgeChart() {
        return dashboardService.patientAgeChart();
    }

    @PostMapping("/imageProcessingChart")
    public Result<List<ImageProcessChart>> imageProcessingChart() {
        return dashboardService.imageProcessingChart();
    }

}
