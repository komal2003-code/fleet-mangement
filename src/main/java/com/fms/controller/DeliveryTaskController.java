package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.entity.DeliveryTask;
import com.fms.service.DeliveryTaskService;

@RestController
@RequestMapping("/task")
public class DeliveryTaskController {

    @Autowired
    private DeliveryTaskService service;

    // ✅ FIXED: vehicleId added
    @PostMapping("/add")
    public DeliveryTask addTask(
            @RequestBody DeliveryTask task,
            @RequestParam Long vehicleId) {

        return service.saveTask(task, vehicleId);
    }

    @GetMapping("/all")
    public List<DeliveryTask> getAllTasks() {
        return service.getAllTasks();
    }
}