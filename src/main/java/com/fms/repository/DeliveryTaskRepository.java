package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fms.entity.DeliveryTask;

public interface DeliveryTaskRepository extends JpaRepository<DeliveryTask, Long> {
	
	
}