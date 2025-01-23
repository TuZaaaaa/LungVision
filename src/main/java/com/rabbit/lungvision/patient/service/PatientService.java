package com.rabbit.lungvision.patient.service;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.patient.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    Result<List<Patient>> list();

    Result<List<Patient>> queryByName(String name);

    Result<Void> insert(Patient patient);

    Result<Void> update(Patient patient);

    Result<Void> delete(int[] idList);
}
