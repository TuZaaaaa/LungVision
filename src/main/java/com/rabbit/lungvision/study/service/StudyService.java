package com.rabbit.lungvision.study.service;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.study.entity.Study;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudyService {

    Result<List<Study>> list();

    Result<List<Study>> queryByPatientId(int patientId);

    Result<Void> insert(Study study);

    Result<Void> update(Study study);

    Result<Void> delete(int[] idList);
}
