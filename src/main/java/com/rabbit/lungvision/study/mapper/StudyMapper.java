package com.rabbit.lungvision.study.mapper;

import com.rabbit.lungvision.patient.entity.Patient;
import com.rabbit.lungvision.study.entity.Study;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {

     List<Study> selectAll();

     List<Study> selectByPatientId(@Param("patientId") int patientId);

     void insert(@Param("study") Study study);

     void update(@Param("study") Study study);

     void batchDelete(@Param("idList") int[] idList);

}
