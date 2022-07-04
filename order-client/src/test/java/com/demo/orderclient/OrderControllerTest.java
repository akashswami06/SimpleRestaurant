package com.demo.orderclient;

import com.demo.orderclient.controller.OrderController;
import com.demo.orderclient.model.dto.MenuItemDto;
import com.demo.orderclient.model.dto.OrderDto;
import com.demo.orderclient.request.OrderRequestParameter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderControllerTest {

    private KafkaSuiteTest server;
    private OrderController orderController;
    private OrderRequestParameter order;

    @Before
    public void setUp() throws Exception {
        server = new KafkaSuiteTest();
        server.start();
        order = new OrderRequestParameter();
        order.setDeviceId("device1");
        order.setTableNumber(1);

        MenuItemDto menuItemDto1 = new MenuItemDto();
        menuItemDto1.setItemName("item1");
        menuItemDto1.setQuantity(5);

        MenuItemDto menuItemDto2 = new MenuItemDto();
        menuItemDto2.setItemName("item2");
        menuItemDto2.setQuantity(5);

        List<MenuItemDto> items = new ArrayList<>();
        items.add(menuItemDto1);
        items.add(menuItemDto2);
        order.setMenuItem(items);
        orderController = new OrderController();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void createOrderTest() {

        String order = orderController.createOrder(this.order);

        Assert.assertNotNull(order);

    }
}
