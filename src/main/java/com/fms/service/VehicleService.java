
package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.Vehicle;
import com.fms.repository.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repo;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }
}

   