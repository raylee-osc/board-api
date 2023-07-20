package com.boardapp.boardapi.order.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardapp.boardapi.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
    
}
