package com.rabbit.lungvision.patient.mapper;

import com.rabbit.lungvision.patient.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {

     List<Patient> selectAll();

     List<Patient> selectByName(@Param("name") String name);

     void insert(@Param("patient") Patient patient);

     void update(@Param("patient") Patient patient);

     void batchDelete(@Param("idList") int[] idList);

}
