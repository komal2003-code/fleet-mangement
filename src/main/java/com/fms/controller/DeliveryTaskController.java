package com.fms.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.DeliveryTaskDto;
import com.fms.entity.DeliveryTask;
import com.fms.service.DeliveryTaskService;

@RestController
@RequestMapping("/task")
public class DeliveryTaskController {

    @Autowired
    private DeliveryTaskService taskService;

    // Add Task
    @PostMapping("/add")
    public DeliveryTask addTask(
            @Valid @RequestBody DeliveryTaskDto dto)
    {
        return taskService.saveTask(dto);
    }

    // Get All Tasks
    @GetMapping("/all")
    public List<DeliveryTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Dispatch
    @PutMapping("/dispatch/{id}")
    public DeliveryTask dispatchTask(@PathVariable Long id)
    {
        return taskService.dispatchTask(id);
    }

    // Transit
    @PutMapping("/transit/{id}")
    public DeliveryTask transitTask(@PathVariable Long id)
    {
        return taskService.transitTask(id);
    }

    // Deliver
    @PutMapping("/deliver/{id}")
    public DeliveryTask deliverTask(@PathVariable Long id)
    {
        return taskService.deliverTask(id);
    }
}