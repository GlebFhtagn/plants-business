package com.example.plantbusiness.repositories;

import com.example.plantbusiness.model.entity.storage.WarehouseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRecordRepository extends JpaRepository<WarehouseRecord, Long> {
}
