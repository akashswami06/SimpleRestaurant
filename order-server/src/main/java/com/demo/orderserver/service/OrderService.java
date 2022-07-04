package com.demo.orderserver.service;

import com.demo.orderserver.model.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService{

    public Order createOrder(Order order);

    public Mono<Order> deleteItemForTableNumber(String tableNumber, String item);

    public Flux<Order> getAllOrder();

}
