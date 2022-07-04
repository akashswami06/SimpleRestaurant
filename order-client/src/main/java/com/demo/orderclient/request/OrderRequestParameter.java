package com.demo.orderclient.request;

import com.demo.orderclient.model.dto.MenuItemDto;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequestParameter {

    private Integer tableNumber;
    private String deviceId;
    //to store item and quantity
    private List<MenuItemDto> menuItem;
}
