package com.vamsisk.spring.boot.starter.couchbase.service;

import com.vamsisk.spring.boot.starter.couchbase.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    void save(Order order);

    Order findById(String orderId);
}
