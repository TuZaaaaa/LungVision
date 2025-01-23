package com.rabbit.lungvision.patient.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.patient.mapper.PatientMapper;
import com.rabbit.lungvision.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;

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
    public Result<Void> delete(int[] idList) {
        patientMapper.batchDelete(idList);
        return Result.success();
    }
}
