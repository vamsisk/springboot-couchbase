package com.vamsisk.spring.boot.starter.couchbase;

import com.vamsisk.spring.boot.starter.couchbase.repository.OrderRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCouchbaseApplicationTests {

    @Autowired
    protected OrderRepository orderRepository;

    @Before
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
