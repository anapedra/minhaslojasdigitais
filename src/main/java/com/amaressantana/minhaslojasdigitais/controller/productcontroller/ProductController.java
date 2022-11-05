package com.amaressantana.minhaslojasdigitais.controller.productcontroller;

import com.amaressantana.minhaslojasdigitais.DTOS.ProductDTO;
import com.amaressantana.minhaslojasdigitais.model.Product;
import com.amaressantana.minhaslojasdigitais.services.pructservice.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        var product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product=productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping
    public ResponseEntity<Page<Product>> findALL(Pageable pageable){
        Page<Product> products=productService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduct(@PathVariable Long id,@RequestBody @Valid ProductDTO productDTO){
        var product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        productService.atualizarProduct(id,product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletProduct(@PathVariable Long id){
        productService.deletProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto foi delatado com sucesso!");
    }

}
