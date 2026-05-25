package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.RouteDto;
import com.fms.entity.Route;
import com.fms.repository.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository repo;

    public Route saveRoute(RouteDto dto) {

        Route route = new Route();

        route.setSource(dto.getSource());
        route.setDestination(dto.getDestination());
        route.setDistance(dto.getDistance());

        return repo.save(route);
    }

    public List<Route> getAllRoutes() {
        return repo.findAll();
    }
}