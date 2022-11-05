package com.amaressantana.minhaslojasdigitais.repositorys;

import com.amaressantana.minhaslojasdigitais.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Long> {
}
