package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.RouteDto;
import com.fms.entity.Route;
import com.fms.service.RouteService;
import com.fms.service.RouteOptimizationService;
import com.fms.dto.RouteResponse;
import com.fms.dto.CoordinateRequest;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;
    
    @Autowired
    private RouteOptimizationService routeOptimizationService;

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
    @PostMapping("/optimize")
    public RouteResponse optimizeRoute(
            @RequestBody CoordinateRequest request) {

        return routeOptimizationService.getRoute(request);
    }

}