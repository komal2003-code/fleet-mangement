package com.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.dto.CoordinateRequest;
import com.fms.dto.RouteResponse;
import com.fms.service.RouteOptimizationService;

@RestController
@RequestMapping("/route")
public class RouteOptimizationController {

    @Autowired
    private RouteOptimizationService service;

    @PostMapping("/optimize")
    public RouteResponse optimizeRoute(
            @RequestBody CoordinateRequest request)
    {
        return service.getRoute(request);
    }
}