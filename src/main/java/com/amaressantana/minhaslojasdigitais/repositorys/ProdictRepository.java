package com.amaressantana.minhaslojasdigitais.repositorys;

import com.amaressantana.minhaslojasdigitais.model.Product;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdictRepository extends JpaRepository<Product,Long> {
}
