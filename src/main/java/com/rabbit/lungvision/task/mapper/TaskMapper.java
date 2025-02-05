package com.rabbit.lungvision.task.mapper;

import com.rabbit.lungvision.task.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    List<Task> selectAll();

}
