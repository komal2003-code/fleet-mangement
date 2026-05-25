package com.fms.dto;

public class DriverDto {

    private String driverName;
    private String licenseNumber;
    private String licenseValidTill;
    private int shiftHours;

    public DriverDto() {
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