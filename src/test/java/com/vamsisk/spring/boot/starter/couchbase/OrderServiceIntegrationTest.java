package com.vamsisk.spring.boot.starter.couchbase;

import com.vamsisk.spring.boot.starter.couchbase.entities.Order;
import com.vamsisk.spring.boot.starter.couchbase.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static java.time.LocalDate.now;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OrderServiceIntegrationTest extends SpringbootCouchbaseApplicationTests {
    public static final String ORDER_1 = "Order::1";

    @Autowired
    private OrderService orderService;

    @Test
    public void testSave() {
        Order order = new Order(1, now(), "customerName");
        orderService.save(order);

        Order newBuilding = orderService.findById(ORDER_1);
        assertThat(newBuilding, equalTo(order));
    }
}
