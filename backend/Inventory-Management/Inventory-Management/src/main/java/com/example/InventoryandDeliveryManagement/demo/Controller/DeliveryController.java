package com.example.InventoryandDeliveryManagement.demo.Controller;

import com.example.InventoryandDeliveryManagement.demo.Model.Delivery;
import com.example.InventoryandDeliveryManagement.demo.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/delivery")
public class DeliveryController{
    @Autowired
    public DeliveryService service;

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery delivery){
        return service.addDelivery(delivery);
    }
    @GetMapping
    public List<Delivery> getAll(){
        return service.getAllItems();
    }
    @GetMapping("/{id}")
    public Delivery getItemById(@PathVariable Long id){
        return service.getItemById(id);
    }
    @PutMapping("/{id}")
    public Delivery updateItem(@PathVariable Long id, @RequestBody Delivery updated){
        return service.updateItem(id, updated);
    }
    @DeleteMapping("/{id}")
    public void deleteItems(@PathVariable Long id){
        service.deleteItems(id);
    }
}
