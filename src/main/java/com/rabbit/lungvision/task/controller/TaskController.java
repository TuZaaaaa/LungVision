package com.rabbit.lungvision.task.controller;

import com.rabbit.lungvision.common.Result;
import com.rabbit.lungvision.task.entity.Task;
import com.rabbit.lungvision.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/list")
    public Result<List<Task>> list() {
        return taskService.list();
    }
}
