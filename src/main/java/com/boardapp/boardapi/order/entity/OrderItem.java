package com.boardapp.boardapi.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Getter;

// ? Order : OrderItem -> 1 : N
@Getter
@Table("order_item")
public class OrderItem {
    @Id
    @Column("item_id")
    private Long itemId;

    @Column("order_id")
    private Long orderId;

    @Column("product_name")
    private String productName;

    @Builder
    public OrderItem(Long itemId, Long orderId, String productName) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.productName = productName;
    }
}
