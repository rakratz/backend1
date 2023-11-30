package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.model.SaleItem;
import com.empresa.service.SaleItemService;

import java.util.List;

@RestController
@RequestMapping("/api/sale-items")
public class SaleItemController {

    private final SaleItemService saleItemService;

    @Autowired
    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public ResponseEntity<List<SaleItem>> getAllSaleItems() {
        List<SaleItem> saleItems = saleItemService.getAllSaleItems();
        return new ResponseEntity<>(saleItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleItem> getSaleItemById(@PathVariable Long id) {
        SaleItem saleItem = saleItemService.getSaleItemById(id);
        if (saleItem != null) {
            return new ResponseEntity<>(saleItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SaleItem> createSaleItem(@RequestBody SaleItem saleItem) {
        SaleItem createdSaleItem = saleItemService.createSaleItem(saleItem);
        return new ResponseEntity<>(createdSaleItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleItem> updateSaleItem(@PathVariable Long id, @RequestBody SaleItem updatedSaleItem) {
        SaleItem saleItem = saleItemService.updateSaleItem(id, updatedSaleItem);
        if (saleItem != null) {
            return new ResponseEntity<>(saleItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaleItem(@PathVariable Long id) {
        if (saleItemService.deleteSaleItem(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
