package com.project.uber.uberApp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private UserDto user;
    private Double rating;
    private String vehicleId;
}
