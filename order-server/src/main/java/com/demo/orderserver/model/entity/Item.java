package com.demo.orderserver.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Item {

    @Column(name = "name")
    private String itemName;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "time_to_prepare")
    private Integer timeToPrepare;

}
