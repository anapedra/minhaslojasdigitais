package com.amaressantana.minhaslojasdigitais.controller.categoryproductcontroller;

import com.amaressantana.minhaslojasdigitais.DTOS.CategoryProductDTO;
import com.amaressantana.minhaslojasdigitais.model.CategoryProduct;
import com.amaressantana.minhaslojasdigitais.services.categoeyproductservice.CategoryProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorys")
public class CategoryProductController {

    private final CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }
    @PostMapping
    public ResponseEntity<Object> saveCategoryProduct(@RequestBody @Valid CategoryProductDTO categoryProductDTO){
        var category=new CategoryProduct();
        BeanUtils.copyProperties(categoryProductDTO,category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryProductService.saveCategoryProduct(category));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryProduct> findById(@PathVariable Long id){
        CategoryProduct categoryProduct=categoryProductService.finaCategoeyProductById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(categoryProduct);
    }
    @GetMapping
    public ResponseEntity<Page<CategoryProduct>> findALL(Pageable pageable){
        Page<CategoryProduct> categoryProducts=categoryProductService.findAllCategoryProduto(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(categoryProducts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCategoryProduct(@PathVariable Long id,@RequestBody @Valid CategoryProductDTO categoryProductDTO){
        var category=new CategoryProduct();
        BeanUtils.copyProperties(categoryProductDTO,category);
        categoryProductService.atualizarCategoryProduto(id,category);
        return ResponseEntity.status(HttpStatus.OK).body(categoryProductService.saveCategoryProduct(category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletCategory(@PathVariable Long id){
        categoryProductService.deleteCategoryProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria delatada com sucesso!");
    }
}
