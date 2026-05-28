package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fms.dto.CoordinateDto;
import com.fms.dto.CoordinateRequest;
import com.fms.dto.RouteResponse;

@Service
public class RouteOptimizationService {

    public RouteResponse getRoute(CoordinateRequest request) {

        try {

            List<CoordinateDto> remaining =
                    new ArrayList<>(request.getStops());

            List<String> optimizedRoute =
                    new ArrayList<>();

            double totalDistance = 0;

            if (remaining.isEmpty()) {

                return new RouteResponse(
                        "0 km",
                        "0 hours",
                        optimizedRoute);
            }

            // Start Point
            CoordinateDto current =
                    remaining.remove(0);

            optimizedRoute.add(current.getName());

            // Nearest Neighbor Logic
            while (!remaining.isEmpty()) {

                CoordinateDto nearest = null;
                double minDistance = Double.MAX_VALUE;

                for (CoordinateDto stop : remaining) {

                    double distance =
                            calculateDistance(
                                    current.getLat(),
                                    current.getLon(),
                                    stop.getLat(),
                                    stop.getLon());

                    if (distance < minDistance) {

                        minDistance = distance;
                        nearest = stop;
                    }
                }

                totalDistance += minDistance;
                current = nearest;

                optimizedRoute.add(current.getName());
                remaining.remove(current);
            }

            // Average Speed
            double avgSpeed = 50;

            double duration =
                    totalDistance / avgSpeed;

            return new RouteResponse(
                    String.format("%.2f km", totalDistance),
                    String.format("%.2f hours", duration),
                    optimizedRoute);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Route optimization failed");
        }
    }

    // Distance Formula
    private double calculateDistance(
            double lat1,
            double lon1,
            double lat2,
            double lon2) {

        double theta = lon1 - lon2;

        double dist =
                Math.sin(Math.toRadians(lat1))
                        * Math.sin(Math.toRadians(lat2))
                        + Math.cos(Math.toRadians(lat1))
                        * Math.cos(Math.toRadians(lat2))
                        * Math.cos(Math.toRadians(theta));

        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return dist;
    }
}