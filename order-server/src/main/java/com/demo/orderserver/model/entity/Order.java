package com.demo.orderserver.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "table_number")
    private Integer tableNumber;
    @Column(name = "device_id")
    private String deviceId;
    @ElementCollection
    private List<Item> menuItem;

    // @ElementCollection
  // private List<MenuItem> menuItemList;


}
