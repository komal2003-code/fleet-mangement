package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.DriverDto;
import com.fms.entity.Driver;
import com.fms.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public Driver addDriver(@RequestBody DriverDto dto) {
        return driverService.saveDriver(dto);
    }

    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }
    @PutMapping("/assign/{driverId}/{vehicleId}")
    public Driver assignDriverToVehicle(
            @PathVariable Long driverId,
            @PathVariable Long vehicleId) {

        return driverService.assignDriverToVehicle(driverId, vehicleId);
    }
}