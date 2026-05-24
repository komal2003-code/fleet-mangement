
package com.fms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotBlank
    private String vehicleNumber;
    //@NotBlank
    private String licensePlate;
    //@Min(1)
    private int capacity;
    //@NotBlank
    private String maintenanceStatus;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}

	public void setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus = maintenanceStatus;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
}
   