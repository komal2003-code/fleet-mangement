package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.Driver;
import com.fms.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public Driver saveDriver(Driver driver) {
        return repo.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return repo.findAll();
    }
}