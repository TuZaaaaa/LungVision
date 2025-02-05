package com.rabbit.lungvision.task.service.impl;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.task.entity.Task;
import com.rabbit.lungvision.task.mapper.TaskMapper;
import com.rabbit.lungvision.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Result<List<Task>> list() {
        List<Task> tasks = taskMapper.selectAll();
        return Result.success(tasks);
    }
}
