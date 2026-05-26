package com.fms.dto;

import java.util.List;

public class CoordinateRequest {

    private List<CoordinateDto> stops;

    public List<CoordinateDto> getStops() {
        return stops;
    }

    public void setStops(List<CoordinateDto> stops) {
        this.stops = stops;
    }
}