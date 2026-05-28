package com.fms.controller;

import java.util.List;

import com.fms.dto.DeliveryTaskDto;
import com.fms.entity.DeliveryTask;
import com.fms.service.DeliveryTaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@Tag(name = "Delivery APIs", description = "Delivery Task Management APIs")
public class DeliveryTaskController {

    @Autowired
    private DeliveryTaskService taskService;

    // Add Task
    @Operation(summary = "Add new delivery task")
    @PostMapping("/add")
    public DeliveryTask addTask(@Valid @RequestBody DeliveryTaskDto dto) {
        return taskService.saveTask(dto);
    }

    // Get All Tasks
    @Operation(summary = "Get all delivery tasks")
    @GetMapping("/all")
    public List<DeliveryTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Dispatch
    @Operation(summary = "Dispatch delivery task")
    @PutMapping("/dispatch/{id}")
    public DeliveryTask dispatchTask(@PathVariable Long id) {
        return taskService.dispatchTask(id);
    }

    // Transit
    @Operation(summary = "Mark task as in transit")
    @PutMapping("/transit/{id}")
    public DeliveryTask transitTask(@PathVariable Long id) {
        return taskService.transitTask(id);
    }

    // Deliver
    @Operation(summary = "Mark task as delivered")
    @PutMapping("/deliver/{id}")
    public DeliveryTask deliverTask(@PathVariable Long id) {
        return taskService.deliverTask(id);
    }
}