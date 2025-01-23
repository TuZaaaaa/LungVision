package com.rabbit.lungvision.patient.controller;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.patient.service.PatientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/list")
    public Result<List<Patient>> list() {
        return patientService.list();
    }

    @PostMapping("/queryByName")
    public Result<List<Patient>> queryByName(@RequestParam String name) {
        return patientService.queryByName(name);
    }

    @PostMapping("/insert")
    public Result<Void> insert(@RequestBody Patient patient) {
        if (StringUtils.isBlank(patient.getName())) {
            return Result.error("患者名字 为空");
        }
        if (patient.getAge() == 0) {
            return Result.error("患者年龄 为空");
        }
        if (StringUtils.isBlank(patient.getGender())) {
            return Result.error("患者性别 为空");
        }
        return patientService.insert(patient);
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody Patient patient) {
        if (patient.getId() == 0) {
            return Result.error("患者ID 为空");
        }
        if (StringUtils.isBlank(patient.getName())) {
            return Result.error("患者名字 为空");
        }
        if (patient.getAge() == 0) {
            return Result.error("患者年龄 为空");
        }
        if (StringUtils.isBlank(patient.getGender())) {
            return Result.error("患者性别 为空");
        }
        return patientService.update(patient);
    }

    @PostMapping("/delete")
    public Result<Void> delete(@RequestBody int[] idList) {
        if (idList == null || idList.length == 0) {
            return Result.error("患者ID列表 为空");
        }
        return patientService.delete(idList);
    }

}
