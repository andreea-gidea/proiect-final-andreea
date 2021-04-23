package com.siit.proiectfinalandreea.plantshop.controller;


import com.siit.proiectfinalandreea.plantshop.model.OrderAddMoreItemsOrRemoveRequest;
import com.siit.proiectfinalandreea.plantshop.model.OrderCreationRequest;
import com.siit.proiectfinalandreea.plantshop.model.OrderDto;
import com.siit.proiectfinalandreea.plantshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public List<OrderDto> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderID}")
    public OrderDto getOrder(@PathVariable(name = "orderID") Integer orderID){
        return orderService.getOrder(orderID);
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderCreationRequest orderCreationRequest){
        return orderService.createOrder(orderCreationRequest);
    }
    @PutMapping
    public OrderDto addToOrder(@RequestBody OrderAddMoreItemsOrRemoveRequest oderAddMoreItemsRequest){
        return orderService.addToOrder(oderAddMoreItemsRequest);
    }
    @DeleteMapping
    public void deleteFromOrder(@RequestBody OrderAddMoreItemsOrRemoveRequest orderAddMoreItemsOrRemoveRequest){
        orderService.deleteFromOrder(orderAddMoreItemsOrRemoveRequest);
    }
    @DeleteMapping("/{orderId}")
    public void deletePost(@PathVariable(name = "orderId") Integer orderId){
        orderService.deleteOrder(orderId);
    }
}
