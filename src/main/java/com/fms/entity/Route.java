package com.fms.entity;

import jakarta.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destination;
    private double distance;

    @OneToOne
    @JoinColumn(name = "delivery_task_id")
    private DeliveryTask deliveryTask;

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public DeliveryTask getDeliveryTask() {
        return deliveryTask;
    }

    public void setDeliveryTask(DeliveryTask deliveryTask) {
        this.deliveryTask = deliveryTask;
    }
}