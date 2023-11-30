package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.SaleItem;
import com.empresa.repository.SaleItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SaleItemService {

    private final SaleItemRepository saleItemRepository;

    @Autowired
    public SaleItemService(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    public SaleItem getSaleItemById(Long id) {
        Optional<SaleItem> optionalSaleItem = saleItemRepository.findById(id);
        return optionalSaleItem.orElse(null);
    }

    public SaleItem createSaleItem(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    public SaleItem updateSaleItem(Long id, SaleItem updatedSaleItem) {
        Optional<SaleItem> optionalSaleItem = saleItemRepository.findById(id);
        if (optionalSaleItem.isPresent()) {
            SaleItem existingSaleItem = optionalSaleItem.get();
            // Atualizar os campos necessários do existingSaleItem com os valores de updatedSaleItem
            // Exemplo: existingSaleItem.setQuantity(updatedSaleItem.getQuantity());
            // ...
            return saleItemRepository.save(existingSaleItem);
        } else {
            return null;
        }
    }

    public boolean deleteSaleItem(Long id) {
        Optional<SaleItem> optionalSaleItem = saleItemRepository.findById(id);
        if (optionalSaleItem.isPresent()) {
            saleItemRepository.delete(optionalSaleItem.get());
            return true;
        } else {
            return false;
        }
    }
}
