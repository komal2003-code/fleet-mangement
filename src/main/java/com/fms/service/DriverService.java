package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fms.entity.Vehicle;
import com.fms.dto.DriverDto;
import com.fms.entity.Driver;
import com.fms.repository.DriverRepository;
import com.fms.repository.VehicleRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;
    
    @Autowired
    private VehicleRepository vehicleRepo;

    public Driver saveDriver(DriverDto dto) {

        Driver driver = new Driver();

        driver.setDriverName(dto.getDriverName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setLicenseValidTill(dto.getLicenseValidTill());
        driver.setShiftHours(dto.getShiftHours());

        return repo.save(driver);
    }
    public Driver assignDriverToVehicle(Long driverId, Long vehicleId) {

        Driver driver = repo.findById(driverId).orElseThrow();
        Vehicle vehicle = vehicleRepo.findById(vehicleId).orElseThrow();

        driver.setVehicle(vehicle);

        return repo.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return repo.findAll();
    }
}