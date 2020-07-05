package com.myspring.starbucks.controller;

import com.myspring.starbucks.controller.request.NewOrderRequest;
import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.model.Order;
import com.myspring.starbucks.model.OrderCoffee;
import com.myspring.starbucks.service.impl.CoffeeOrderServiceImpl;
import com.myspring.starbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/21
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeOrderServiceImpl coffeeOrderService;

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderCoffee> create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.queryCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[] {});
        log.info("Coffees of orders: {}", coffeeList);
        return coffeeOrderService.createOrder(newOrder.getCustomer(), coffeeList);
    }

    @GetMapping(value = "/{id}")
    public Order queryOrder(@PathVariable("id") Long id) {
        return coffeeOrderService.queryOrder(id);
    }
}
