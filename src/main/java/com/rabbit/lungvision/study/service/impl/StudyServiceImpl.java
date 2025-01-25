package com.rabbit.lungvision.study.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.study.entity.Study;
import com.rabbit.lungvision.study.mapper.StudyMapper;
import com.rabbit.lungvision.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    StudyMapper studyMapper;

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
}
