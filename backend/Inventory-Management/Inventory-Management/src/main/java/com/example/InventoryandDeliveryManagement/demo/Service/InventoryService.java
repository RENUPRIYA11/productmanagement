package com.example.InventoryandDeliveryManagement.demo.Service;

import com.example.InventoryandDeliveryManagement.demo.Model.Inventory;
import com.example.InventoryandDeliveryManagement.demo.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService{

    @Autowired
    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo){
        this.repo = repo;
    }

    public Inventory addInventory(Inventory inventory){
        return repo.save(inventory);
    }
    public List<Inventory> getAllItems(){
        return repo.findAll();
    }
    public Inventory getItemById(Long id){
       return repo.findById(id).orElse(null);
    }
    public Inventory updateItem(Long id, Inventory updated){
        Inventory existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Item not found!"));
        existing.setName(updated.getName());
        existing.setQuantity(updated.getQuantity());
        return repo.save(existing);
    }
    public void deleteItems(Long id){
        repo.deleteById(id);
    }
    public boolean isInStock(Long id) {
        Inventory item = repo.findById(id).orElse(null);
        return item != null && item.getQuantity() > 0;
    }
}
