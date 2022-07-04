package com.demo.orderserver.request;

import lombok.Data;

@Data
public class MenuItemRequestParameter {
    private String itemId;
    private String quantity;
}
