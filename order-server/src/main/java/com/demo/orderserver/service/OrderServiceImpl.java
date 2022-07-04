package com.demo.orderserver.service;

import com.demo.orderserver.model.entity.Order;
import com.demo.orderserver.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){

       return  orderRepository.save(order);
    }

    @Override
    public Mono<Order> deleteItemForTableNumber(String tableNumber,
                                                String item){
        return null;
    }

    @Override
    public Flux<Order> getAllOrder(){
        return (Flux<Order>) orderRepository.findAll();
    }


    public Mono<Order> getItemByTableNumber(int tableNumber) {
        return (Mono<Order>) orderRepository.findAllByTableNumber(tableNumber);
    }

}
