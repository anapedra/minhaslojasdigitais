package com.amaressantana.minhaslojasdigitais.repositorys.ordenitemrepository;

import com.amaressantana.minhaslojasdigitais.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
