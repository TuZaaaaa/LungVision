package com.rabbit.lungvision.study.controller;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.patient.service.PatientService;
import com.rabbit.lungvision.study.entity.Study;
import com.rabbit.lungvision.study.service.StudyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/study")
public class StudyController {

    @Autowired
    StudyService studyService;

    @PostMapping("/list")
    public Result<List<Study>> list() {
        return studyService.list();
    }

    @PostMapping("/queryByPatientId")
    public Result<List<Study>> queryByPatientId(@RequestParam int patientId) {
        return studyService.queryByPatientId(patientId);
    }

    @PostMapping("/insert")
    public Result<Void> insert(@RequestBody Study study) {
        if (study.getPatientId() == 0) {
            return Result.error("患者ID 为空");
        }
        if (study.getStudyDate() == null) {
            return Result.error("检查日期 为空");
        }
        if (StringUtils.isBlank(study.getDescription())) {
            return Result.error("检查描述 为空");
        }
        return studyService.insert(study);
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody Study study) {
        if (study.getId() == 0) {
            return Result.error("检查ID 为空");
        }
        if (study.getPatientId() == 0) {
            return Result.error("患者ID 为空");
        }
        if (study.getStudyDate() == null) {
            return Result.error("检查日期 为空");
        }
        if (StringUtils.isBlank(study.getDescription())) {
            return Result.error("检查描述 为空");
        }
        return studyService.update(study);
    }

    @PostMapping("/delete")
    public Result<Void> delete(@RequestBody int[] idList) {
        if (idList == null || idList.length == 0) {
            return Result.error("检查ID列表 为空");
        }
        return studyService.delete(idList);
    }

}
