
package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}