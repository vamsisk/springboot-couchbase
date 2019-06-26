package com.vamsisk.spring.boot.starter.couchbase.entities;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES, delimiter = "::")
    private String id;

    @IdPrefix
    private String prefix = "Order";

    @IdAttribute
    private int orderId;

    @Field
    private LocalDate orderDate;

    @Field
    private String customerName;

    @Transient
    private String dummyField = "Dummy Field 4";

    public Order(int orderId, LocalDate orderDate, String customerName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return orderId == order.orderId &&
               orderDate.equals(order.orderDate) &&
               customerName.equals(order.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, customerName);
    }
}
