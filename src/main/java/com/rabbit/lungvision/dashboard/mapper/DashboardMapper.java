package com.rabbit.lungvision.dashboard.mapper;

import com.rabbit.lungvision.dashboard.entity.ImageProcessChart;
import com.rabbit.lungvision.dashboard.entity.PanelGroup;
import com.rabbit.lungvision.dashboard.entity.PatientAgeChart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DashboardMapper {

    PanelGroup getPanelGroup();

    PatientAgeChart getPatientAgeChart();

    List<ImageProcessChart> getImageProcessingChart();

}
