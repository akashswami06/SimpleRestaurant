package com.demo.orderserver.consumer;

import com.demo.orderserver.model.entity.Item;
import com.demo.orderserver.model.entity.Order;
import com.demo.orderserver.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class OrderConsumerListner {

    @Autowired
    OrderService orderService;

    @KafkaListener(topics = "${spring.kafka.topic}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void exchangeEventListener(String orderMessage) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Order order = mapper.readValue(orderMessage, Order.class);
            generateCookingTime(order);
            orderService.createOrder(order);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void generateCookingTime(Order order) {
        List<Item> menuItem = order.getMenuItem();
        if(!menuItem.isEmpty()){
            for(Item item : menuItem){
                //set random
                Random r = new Random();
                int low = 5;
                int high = 15;
                int result = r.nextInt(high-low) + low;
                item.setTimeToPrepare(result);
            }
        }
    }

}
