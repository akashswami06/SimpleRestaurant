package com.demo.orderclient.service;

import com.demo.orderclient.model.dto.OrderDto;
import com.demo.orderclient.request.OrderRequestParameter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService{

    public String createOrder(OrderRequestParameter order);

    public String deleteItemForTableNumber(String tableNumber, String item);

    public Flux<OrderDto> getAllOrder();

    public Mono<OrderDto> getItemByTableNumber(String tableNumber, String item);

}
