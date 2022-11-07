package com.amaressantana.minhaslojasdigitais.services.orderitemservice;

import com.amaressantana.minhaslojasdigitais.model.OrderItem;
import com.amaressantana.minhaslojasdigitais.repositorys.ordenitemrepository.OrderItemRepository;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class OrdenItemService {

    private final OrderItemRepository orderItemRepository;
    public OrdenItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem saveOrderItem(OrderItem orderItem){
      return   orderItemRepository.saveAndFlush(orderItem);
    }
    public OrderItem findOrderIntemById(Long id){
        Optional<OrderItem> orderItem=orderItemRepository.findById(id);
        return orderItem.orElseThrow(
                ()-> new EntityNotFoundExcepion("Id "+ id+" not found!"));
    }
    public Page<OrderItem> findAll(Pageable pageable){
        Page<OrderItem>orderItems=orderItemRepository.findAll(pageable);
        return orderItems;
    }
    public void Delatar(Long id){
        orderItemRepository.deleteById(id);
    }

}
