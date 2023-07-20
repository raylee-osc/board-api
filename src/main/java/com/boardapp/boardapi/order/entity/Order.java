package com.boardapp.boardapi.order.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// ? Order : OrderItem -> 1 : N
@Getter
@Table("order")
public class Order {
    @Id
    @Column("order_id")
    private Long orderId;

    @Column("order_name")
    private String orderName;

    @Setter
    @MappedCollection(idColumn = "order_id", keyColumn = "item_id")
    private List<OrderItem> itemList = new ArrayList<>();

    public void addItem(OrderItem item) {
        this.itemList.add(item);
    }

    @Builder
    public Order(Long orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }
}
