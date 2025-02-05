package com.rabbit.lungvision.task.service;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.task.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Result<List<Task>> list();
}
