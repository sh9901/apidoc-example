package com.example.service.impl;

import com.example.service.ITaskService;
import com.example.vo.request.NewTaskRequest;
import com.example.vo.request.TaskFilterRequest;
import com.example.vo.response.TaskDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Override
    public boolean addTask(NewTaskRequest request) {
        return false;
    }

    @Override
    public TaskDetailResponse queryTaskDetail(int taskId) {
        return null;
    }

    @Override
    public List<TaskDetailResponse> queryTasks(TaskFilterRequest request) {
        return null;
    }
}
