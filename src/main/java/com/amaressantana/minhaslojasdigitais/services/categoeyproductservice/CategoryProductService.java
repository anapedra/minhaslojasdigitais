package com.amaressantana.minhaslojasdigitais.services.categoeyproductservice;

import com.amaressantana.minhaslojasdigitais.model.CategoryProduct;
import com.amaressantana.minhaslojasdigitais.repositorys.CategoryProductRepository;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;
    public CategoryProductService(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }
    public CategoryProduct saveCategoryProduct(CategoryProduct categoryProduct){
        return categoryProductRepository.saveAndFlush(categoryProduct);
    }
    public CategoryProduct finaCategoeyProductById(Long id){
        Optional<CategoryProduct> categoryProduct=categoryProductRepository.findById(id);
        return categoryProduct.orElseThrow(
                ()->new EntityNotFoundExcepion("Id "+id+" not found!"));
    }
    public Page<CategoryProduct> findAllCategoryProduto(Pageable pageable){
        Page<CategoryProduct> categoryProducts=categoryProductRepository.findAll(pageable);
        return categoryProducts;
    }
    public CategoryProduct atualizarCategoryProduto(Long id,CategoryProduct categoryProduct){
        finaCategoeyProductById(id);
        categoryProduct.setId(id);
        return  categoryProduct;
    }
    public void deleteCategoryProduct(Long id){
        finaCategoeyProductById(id);
        categoryProductRepository.deleteById(id);
    }
}
