
package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.entity.Vehicle;
import com.fms.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.saveVehicle(vehicle);
    }

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }
}