package com.boardapp.boardapi.order.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boardapp.boardapi.order.entity.Order;
import com.boardapp.boardapi.order.entity.OrderItem;
import com.boardapp.boardapi.order.repository.OrderItemRepository;
import com.boardapp.boardapi.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @GetMapping
    public List<Order> findAllOrders() {
        Iterable<Order> entityList = this.orderRepository.findAll();

        List<Order> dtoList = new ArrayList<>();

        for(Order entity: entityList) {
            dtoList.add(entity);
        }

        return dtoList;
    }

    @GetMapping("/items")
    public List<OrderItem> findAllOrderItems() {
        Iterable<OrderItem> entityList = this.orderItemRepository.findAll();

        List<OrderItem> dtoList = new ArrayList<>();

        for(OrderItem entity: entityList) {
            dtoList.add(entity);
        }

        return dtoList;
    }
}
