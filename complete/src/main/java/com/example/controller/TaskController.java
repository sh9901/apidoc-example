package com.example.controller;

import com.example.service.ITaskService;
import com.example.vo.request.NewTaskRequest;
import com.example.vo.request.TaskFilterRequest;
import com.example.vo.response.TaskDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    ITaskService taskService;

    @PostMapping("/task/")
    boolean addTask(@RequestBody NewTaskRequest task) {
        return taskService.addTask(task);
    }

    /**
     * 使用任务ID查询任务详细信息
     *
     * @param taskId
     * @return
     */
    @GetMapping("/task/{taskId}")
    TaskDetailResponse queryTaskDetail(@PathVariable int taskId) {
        return taskService.queryTaskDetail(taskId);
    }

    /**
     * 使用post查询任务
     *
     * @param filter
     * @return
     */
    @PostMapping("/task/query")
    List<TaskDetailResponse> queryTasks(@RequestBody TaskFilterRequest filter) {
        return taskService.queryTasks(filter);
    }
}
