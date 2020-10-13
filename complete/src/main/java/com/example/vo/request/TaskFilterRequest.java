package com.example.vo.request;

import lombok.Data;
import java.util.Date;

@Data
public class TaskFilterRequest {
    private int taskId;
    private int flowId;

    /**
     * todo,必填
     */
    private Date createdTime;

    /**
     * todo,必填
     */
    private Date completedTime;
}
