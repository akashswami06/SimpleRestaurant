package com.demo.orderclient.service;

import com.demo.orderclient.model.dto.OrderDto;
import com.demo.orderclient.request.OrderRequestParameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private KafkaTemplate<String, String> orderKafkaTemplate;


    @Value(value = "${kafka.message.exchangeEventTopic.name}")
    private String topicName;

    public String createOrder(OrderRequestParameter order){

        try {
            initiate_Kafka_Event_for_Create(topicName, order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Order sent to queue.";
    }

    @Override
    public String deleteItemForTableNumber(String tableNumber,
                                                String item){
        return null;
    }

    @Override
    public Flux<OrderDto> getAllOrder(){
        return null;
    }

    @Override
    public Mono<OrderDto> getItemByTableNumber(String tableNumber, String item) {
        return null;
    }

    /****************** Start :: intiate kafka event for create ******************/
    private void initiate_Kafka_Event_for_Create(String topicName, OrderRequestParameter order) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String message =objectMapper.writeValueAsString(order);
        ListenableFuture<SendResult<String, String>> future =
                orderKafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message successfully");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }

    /****************** End :: intiate kafka event for create ******************/

}
