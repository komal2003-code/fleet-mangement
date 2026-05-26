package com.fms.dto;

import java.util.List;

public class RouteResponse {

    private String distance;
    private String duration;
    private List<String> optimizedRoute;

    public RouteResponse() {
    }

    public RouteResponse(String distance,
                         String duration,
                         List<String> optimizedRoute) {
        this.distance = distance;
        this.duration = duration;
        this.optimizedRoute = optimizedRoute;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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