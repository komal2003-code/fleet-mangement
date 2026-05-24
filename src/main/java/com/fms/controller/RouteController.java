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
    private RouteService service;

    @PostMapping("/add")
    public Route addRoute(@RequestBody Route route,
                          @RequestParam Long taskId) {

        return service.saveRoute(route, taskId);
    }

    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return service.getAllRoutes();
    }
}