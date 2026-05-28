package com.fms.dto;

import java.util.List;

public class RouteResponse {

    private String totalDistance;
    private String duration;
    private List<String> optimizedRoute;

    // Default Constructor
    public RouteResponse() {
    }

    // Parameterized Constructor
    public RouteResponse(String totalDistance,
                         String duration,
                         List<String> optimizedRoute) {

        this.totalDistance = totalDistance;
        this.duration = duration;
        this.optimizedRoute = optimizedRoute;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<String> getOptimizedRoute() {
        return optimizedRoute;
    }

    public void setOptimizedRoute(List<String> optimizedRoute) {
        this.optimizedRoute = optimizedRoute;
    }
}