package com.boardapp.boardapi.order.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.order.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{
    
}
