package com.demo.orderclient.controller;

import com.demo.orderclient.request.OrderRequestParameter;
import com.demo.orderclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/createOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequestParameter orderRequest) {
        return orderService.createOrder(orderRequest);

    }


}
