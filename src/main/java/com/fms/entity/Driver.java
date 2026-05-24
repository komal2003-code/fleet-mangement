package com.fms.entity;

import jakarta.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;
    private String licenseNumber;
    private String licenseValidTill;
    private int shiftHours;

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseValidTill() {
        return licenseValidTill;
    }

    public void setLicenseValidTill(String licenseValidTill) {
        this.licenseValidTill = licenseValidTill;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }
}