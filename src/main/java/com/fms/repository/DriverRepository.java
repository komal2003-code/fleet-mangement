package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}