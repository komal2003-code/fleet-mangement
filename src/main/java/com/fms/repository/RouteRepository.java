package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}