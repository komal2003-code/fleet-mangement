package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.DeliveryTaskDto;
import com.fms.entity.DeliveryTask;
import com.fms.repository.DeliveryTaskRepository;

@Service
public class DeliveryTaskService {

    @Autowired
    private DeliveryTaskRepository repo;

    // ✅ 1. DTO version (REST / API use)
    public DeliveryTask saveTask(DeliveryTaskDto dto) {

        DeliveryTask task = new DeliveryTask();

        task.setPickupLocation(dto.getPickupLocation());
        task.setDropLocation(dto.getDropLocation());
        task.setStatus(dto.getStatus());

        return repo.save(task);
    }

    // ✅ 2. ENTITY version (HTML form use)
    public DeliveryTask saveTask(DeliveryTask task) {
        return repo.save(task);
    }

    // GET ALL
    public List<DeliveryTask> getAllTasks() {
        return repo.findAll();
    }
}