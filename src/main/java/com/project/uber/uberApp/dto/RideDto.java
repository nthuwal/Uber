package com.project.uber.uberApp.dto;

import com.project.uber.uberApp.entities.Driver;
import com.project.uber.uberApp.entities.Rider;
import com.project.uber.uberApp.entities.enums.PaymentMethod;
import com.project.uber.uberApp.entities.enums.RideStatus;

import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {
    private String id;
    private String otp;
    private Point pickUpLocation;
    private Point dropOffLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private RideStatus rideStatus;
    private PaymentMethod paymentMethod;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
