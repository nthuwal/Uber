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

    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickUpLocation) AS distance " +
            "FROM driver AS d " +
            "where available = true " +
            "AND ST_DWithin(d.current_location, :pickUpLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10 ",
            nativeQuery = true)
    List<Driver> findTenMatchingDrivers(Point pickUpLocation);

    @Query(value = "SELECT d.* " +
            "FROM driver AS d " +
            "where available = true AND ST_DWithin(d.current_location, :pickUpLocation, 10000) " +
            "Order By d.rating DESC " +
            "LIMIT 10 ",
            nativeQuery = true)
    List<Driver> findTenNearbyTopRatedDrivers(Point pickUpLocation);
}
