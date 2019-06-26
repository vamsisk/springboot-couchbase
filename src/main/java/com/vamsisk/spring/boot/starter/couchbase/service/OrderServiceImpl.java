package com.vamsisk.spring.boot.starter.couchbase.service;

import com.vamsisk.spring.boot.starter.couchbase.entities.Order;
import com.vamsisk.spring.boot.starter.couchbase.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Data not found"));
    }
}
