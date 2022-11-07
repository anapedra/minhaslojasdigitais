package com.amaressantana.minhaslojasdigitais.controller.orderitemcontroller;

import com.amaressantana.minhaslojasdigitais.model.OrderItem;
import com.amaressantana.minhaslojasdigitais.services.orderitemservice.OrdenItemService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderitems")
public class OderItemController {

    private final OrdenItemService  ordenItemService;
    public OderItemController(OrdenItemService ordenItemService) {
        this.ordenItemService = ordenItemService;
    }

    @PostMapping
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody @Valid OrderItem orderItem){
        ordenItemService.saveOrderItem(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItem);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> findOrderItemById(@PathVariable Long id){
        OrderItem orderItem=ordenItemService.findOrderIntemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderItem);
    }
    @GetMapping
    public ResponseEntity<Page<OrderItem>> findAllOrderItem(Pageable pageable){
        Page<OrderItem>orderItems=ordenItemService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(orderItems);
    }

}
