package com.vamsisk.spring.boot.starter.couchbase.repository;

import com.vamsisk.spring.boot.starter.couchbase.entities.Order;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "order", viewName = "all")
public interface OrderRepository extends CouchbasePagingAndSortingRepository<Order, String> {

    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(String s);
}
