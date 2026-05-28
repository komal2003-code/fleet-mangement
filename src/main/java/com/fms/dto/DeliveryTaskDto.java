package com.fms.dto;
import jakarta.validation.constraints.NotBlank;
public class DeliveryTaskDto {

    //private String pickupLocation;
    @NotBlank(message = "Pickup location is required")
    private String pickupLocation;
    //private String dropLocation;
    
    @NotBlank(message = "Drop location is required")
    private String dropLocation;
    private String status;
    
    private Long vehicleId;
    private Long driverId;

    public DeliveryTaskDto() {
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}