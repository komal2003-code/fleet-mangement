package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fms.entity.Route;
import com.fms.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    // ADD ROUTE (simple entity based - BEST FIX)
    @PostMapping("/add")
    public Route addRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    // GET ALL ROUTES
    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}