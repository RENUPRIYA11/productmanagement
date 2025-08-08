package com.example.InventoryandDeliveryManagement.demo.Controller;
import com.example.InventoryandDeliveryManagement.demo.Model.Inventory;
import com.example.InventoryandDeliveryManagement.demo.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inventory")
public class InventoryController{
    @Autowired
    public InventoryService service;

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory){
        return service.addInventory(inventory);
    }
    @GetMapping
    public List<Inventory> getAll(){
        return service.getAllItems();
    }
    @GetMapping("/{id}")
    public Inventory getItemById(@PathVariable Long id){
        return service.getItemById(id);
    }
    @PutMapping("/{id}")
    public Inventory updateItem(@PathVariable Long id, @RequestBody Inventory updated){
        return service.updateItem(id, updated);
    }
    @DeleteMapping("/{id}")
    public void deleteItems(@PathVariable Long id){
        service.deleteItems(id);
    }
    @GetMapping("/check/{id}")
    public boolean isInStock(@PathVariable Long id) {
        return service.isInStock(id);
    }
}

