package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//ST_Distance(point1, point2)
//ST_DWithin(point1, 10000)
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query(value = "SELECT d, ST_Distance(d.currentLocation, :pickUpLocation) AS distance " +
            "FROM Driver AS d " +
            "where available = true " +
            "AND ST_DWithin(d.currentLocation, :pickUpLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10",
            nativeQuery = true)
    List<Driver> findMatchingDrivers(Point pickUpLocation);
}
