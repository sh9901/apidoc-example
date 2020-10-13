package com.example.vo.response;

import com.example.model.TaskFetch;
import com.example.model.TaskProperty;
import lombok.Data;

import java.util.List;

@Data
public class TaskDetailResponse {
    private int taskId;
    private int flowId;

    private List<TaskFetch> fetches;
    private List<TaskProperty> properties;

    private String accessToken;
}
