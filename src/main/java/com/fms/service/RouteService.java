package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.Route;
import com.fms.entity.DeliveryTask;
import com.fms.repository.RouteRepository;
import com.fms.repository.DeliveryTaskRepository;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepo;

    @Autowired
    private DeliveryTaskRepository taskRepo;

    public Route saveRoute(Route route, Long taskId) {

        DeliveryTask task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        route.setDeliveryTask(task);

        return routeRepo.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepo.findAll();
    }
}