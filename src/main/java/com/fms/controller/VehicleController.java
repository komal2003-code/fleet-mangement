package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.VehicleDto;
import com.fms.entity.Vehicle;
import com.fms.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Add Vehicle
    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody VehicleDto dto) {
        return vehicleService.saveVehicle(dto);
    }

    // Get All Vehicles
    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}