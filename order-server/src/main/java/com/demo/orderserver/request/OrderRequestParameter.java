package com.demo.orderserver.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestParameter {

    private Integer tableNumber;
    private String deviceId;
    private List<MenuItemRequestParameter> menuItemList;
}
