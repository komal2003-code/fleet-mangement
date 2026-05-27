package com.fms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fms.entity.Route;
import com.fms.repository.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository repo;

    public Route saveRoute(Route route) {
        return repo.save(route);
    }

    public List<Route> getAllRoutes() {
        return repo.findAll();
    }

    public Route getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    public void deleteRoute(Long id) {
        repo.deleteById(id);
    }
}