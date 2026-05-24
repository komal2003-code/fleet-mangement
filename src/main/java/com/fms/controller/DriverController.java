package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.entity.Driver;
import com.fms.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping("/add")
    public Driver addDriver(@RequestBody Driver driver) {
        return service.saveDriver(driver);
    }

    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }
}