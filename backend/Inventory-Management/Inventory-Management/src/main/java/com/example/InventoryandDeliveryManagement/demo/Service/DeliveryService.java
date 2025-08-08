package com.example.InventoryandDeliveryManagement.demo.Service;

import com.example.InventoryandDeliveryManagement.demo.Model.Delivery;
import com.example.InventoryandDeliveryManagement.demo.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private final DeliveryRepository repo;

    public DeliveryService(DeliveryRepository repo){
        this.repo = repo;
    }

    public Delivery addDelivery(Delivery delivery){
        return repo.save(delivery);
    }
    public List<Delivery> getAllItems(){
        return repo.findAll();
    }
    public Delivery getItemById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Delivery updateItem(Long id, Delivery updated){
        Delivery existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Item not found!"));
        existing.setStatus(updated.getStatus());
        existing.setDate(updated.getDate());
        existing.setTime(updated.getTime());
        return repo.save(existing);
    }
    public void deleteItems(Long id){
        repo.deleteById(id);
    }
}
