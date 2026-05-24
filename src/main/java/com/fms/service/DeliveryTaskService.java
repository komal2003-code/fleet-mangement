package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.DeliveryTask;
import com.fms.entity.Vehicle;
import com.fms.repository.DeliveryTaskRepository;
import com.fms.repository.VehicleRepository;

@Service
public class DeliveryTaskService {

    @Autowired
    private DeliveryTaskRepository taskRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    public DeliveryTask saveTask(DeliveryTask task, Long vehicleId) {

        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        task.setVehicle(vehicle);

        return taskRepo.save(task);
    }

    public List<DeliveryTask> getAllTasks() {
        return taskRepo.findAll();
    }
}