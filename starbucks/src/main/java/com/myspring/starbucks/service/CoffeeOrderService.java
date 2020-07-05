package com.myspring.starbucks.service;

import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.model.Order;
import com.myspring.starbucks.model.OrderCoffee;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/21
 */
public interface CoffeeOrderService {

    public List<OrderCoffee> createOrder(String customer, Coffee...coffee);

    public Order queryOrder(Long id);
}
