package com.rabbit.lungvision.patient.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.patient.mapper.PatientMapper;
import com.rabbit.lungvision.patient.service.PatientService;
import com.rabbit.lungvision.study.entity.Study;
import com.rabbit.lungvision.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;

    @Autowired
    StudyService studyService;

    @Override
    public Result<List<Patient>> list() {
        List<Patient> patients = patientMapper.selectAll();
        return Result.success(patients);
    }

    @Override
    public Result<List<Patient>> queryByName(String name) {
        List<Patient> patients = patientMapper.selectByName(name);
        return Result.success(patients);
    }

    @Override
    public Result<Void> insert(Patient patient) {
        patientMapper.insert(patient);
        return Result.success();
    }

    @Override
    public Result<Void> update(Patient patient) {
        patientMapper.update(patient);
        return Result.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Void> delete(int[] idList) {
        // 删除关联的检查记录
        List<Study> studies = studyService.queryByPatientIdList(Arrays.stream(idList).boxed().collect(Collectors.toList()));
        studyService.delete(studies.stream().mapToInt(Study::getId).toArray());

        patientMapper.batchDelete(idList);
        return Result.success();
    }
}
