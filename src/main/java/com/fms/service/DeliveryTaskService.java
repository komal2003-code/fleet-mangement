package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.DeliveryTaskDto;
import com.fms.entity.DeliveryStatus;
import com.fms.entity.DeliveryTask;
import com.fms.repository.DeliveryTaskRepository;
import com.fms.entity.Driver;
import com.fms.entity.Vehicle;
import com.fms.repository.DriverRepository;
import com.fms.repository.VehicleRepository;

@Service
public class DeliveryTaskService {

    @Autowired
    private DeliveryTaskRepository repo;
    
    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    // DTO save (API)
    public DeliveryTask saveTask(DeliveryTaskDto dto) {

        DeliveryTask task = new DeliveryTask();

        task.setPickupLocation(dto.getPickupLocation());
        task.setDropLocation(dto.getDropLocation());

        // Default status
        task.setStatus(DeliveryStatus.UNASSIGNED);

        // Vehicle Fetch
        Vehicle vehicle = vehicleRepo.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        task.setVehicle(vehicle);

        // Driver Fetch
        Driver driver = driverRepo.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        task.setDriver(driver);

        return repo.save(task);
    }

    // Entity save (HTML form)
    public DeliveryTask saveTask(DeliveryTask task) {

        task.setStatus(DeliveryStatus.UNASSIGNED);

        return repo.save(task);
    }

    // Get All
    public List<DeliveryTask> getAllTasks() {
        return repo.findAll();
    }
    public DeliveryTask dispatchTask(Long id) {

        DeliveryTask task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if(task.getStatus() != DeliveryStatus.UNASSIGNED)
        {
            throw new RuntimeException("Only UNASSIGNED task can be dispatched");
        }

        task.setStatus(DeliveryStatus.DISPATCHED);

        return repo.save(task);
    }
    public DeliveryTask transitTask(Long id) {

        DeliveryTask task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if(task.getStatus() != DeliveryStatus.DISPATCHED)
        {
            throw new RuntimeException("Task must be DISPATCHED first");
        }

        task.setStatus(DeliveryStatus.IN_TRANSIT);

        return repo.save(task);
    }
    public DeliveryTask deliverTask(Long id) {

        DeliveryTask task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if(task.getStatus() != DeliveryStatus.IN_TRANSIT)
        {
            throw new RuntimeException("Task must be IN_TRANSIT first");
        }

        task.setStatus(DeliveryStatus.DELIVERED);

        return repo.save(task);
    }
}