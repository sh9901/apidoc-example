package com.example.service;

import com.example.vo.request.NewTaskRequest;
import com.example.vo.request.TaskFilterRequest;
import com.example.vo.response.TaskDetailResponse;

import java.util.List;

public interface ITaskService {
    boolean addTask(NewTaskRequest request);

    TaskDetailResponse queryTaskDetail(int taskId);

    List<TaskDetailResponse> queryTasks(TaskFilterRequest request);
}
