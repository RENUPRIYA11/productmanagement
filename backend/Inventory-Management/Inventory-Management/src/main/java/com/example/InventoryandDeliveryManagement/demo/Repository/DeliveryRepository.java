package com.example.InventoryandDeliveryManagement.demo.Repository;

import com.example.InventoryandDeliveryManagement.demo.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}