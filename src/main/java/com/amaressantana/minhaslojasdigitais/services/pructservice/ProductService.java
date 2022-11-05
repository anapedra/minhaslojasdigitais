package com.amaressantana.minhaslojasdigitais.services.pructservice;

import com.amaressantana.minhaslojasdigitais.model.Product;
import com.amaressantana.minhaslojasdigitais.repositorys.ProdictRepository;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProdictRepository prodictRepository;
    public ProductService(ProdictRepository prodictRepository) {
        this.prodictRepository = prodictRepository;
    }
    public Product saveProduct(Product product){
        return prodictRepository.saveAndFlush(product);
    }
    public Product findProductById(Long id){
        Optional<Product> product=prodictRepository.findById(id);
        return product.orElseThrow(
                ()-> new EntityNotFoundExcepion("Id "+ id+ " not found!"));
    }
    public Page<Product> findAll(Pageable pageable){
        Page<Product>products=prodictRepository.findAll(pageable);
        return products;
    }
    public Product atualizarProduct(Long id,Product product){
        deletProduct(id);
        product.setId(id);
        return product;
    }
    public void deletProduct(Long id){
        findProductById(id);
        prodictRepository.deleteById(id);
    }
}
