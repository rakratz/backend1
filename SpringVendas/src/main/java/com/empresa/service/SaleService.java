package com.empresa.service;

import com.empresa.model.Sale;
import com.empresa.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        // Adicione aqui a lógica necessária antes de salvar, se necessário
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale updatedSale) {
        Optional<Sale> existingSale = saleRepository.findById(id);

        if (existingSale.isPresent()) {
            Sale sale = existingSale.get();
            // Atualize os campos relevantes do objeto Sale com os valores de updatedSale
            sale.setCustomer(updatedSale.getCustomer());
            sale.setDate(updatedSale.getDate());
            sale.setPaymentMethod(updatedSale.getPaymentMethod());

            // Adicione aqui a lógica necessária antes de salvar, se necessário
            return saleRepository.save(sale);
        } else {
            return null; // Ou lançar uma exceção, dependendo dos requisitos
        }
    }

    public boolean deleteSale(Long id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
