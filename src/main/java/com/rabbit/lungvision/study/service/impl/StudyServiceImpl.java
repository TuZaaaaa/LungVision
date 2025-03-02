package com.rabbit.lungvision.study.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.patient.mapper.PatientMapper;
import com.rabbit.lungvision.study.entity.Study;
import com.rabbit.lungvision.study.mapper.StudyMapper;
import com.rabbit.lungvision.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;


@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    StudyMapper studyMapper;

    @Autowired
    PatientMapper patientMapper;

    @Override
    public Result<List<Study>> list() {
        List<Study> studies = studyMapper.selectAll();
        return Result.success(studies);
    }

    @Override
    public Result<List<Study>> queryByPatientId(int patientId) {
        List<Study> studies = studyMapper.selectByPatientId(patientId);
        return Result.success(studies);
    }

    @Override
    public Result<Void> insert(Study study) {
        List<Patient> patients = patientMapper.selectById(study.getPatientId());
        if (patients.isEmpty()) {
            return Result.error("请选择可用的患者编码");
        }
        study.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        studyMapper.insert(study);
        return Result.success();
    }

    @Override
    public Result<Void> update(Study study) {
        System.out.println(study.getStudyDate());
        study.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        studyMapper.update(study);
        return Result.success();
    }

    @Override
    public Result<Void> delete(int[] idList) {
        studyMapper.batchDelete(idList);
        return Result.success();
    }

    @Override
    public List<Study> queryByPatientIdList(List<Integer> patientIdList) {
        return studyMapper.queryByPatientIdList(patientIdList);
    }

}
