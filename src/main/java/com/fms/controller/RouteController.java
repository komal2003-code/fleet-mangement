package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.RouteDto;
import com.fms.entity.Route;
import com.fms.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    // Add Route
    @PostMapping("/add")
    public Route addRoute(@RequestBody RouteDto dto) {
        return routeService.saveRoute(dto);
    }

    // Get All Routes
    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}