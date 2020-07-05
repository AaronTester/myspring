package com.myspring.starbucks.service.impl;

import com.myspring.starbucks.mapper.OrderCoffeeMapper;
import com.myspring.starbucks.mapper.OrderMapper;
import com.myspring.starbucks.model.Order;
import com.myspring.starbucks.model.OrderCoffee;
import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.model.OrderState;
import com.myspring.starbucks.service.CoffeeOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CoffeeOrderServiceImpl implements CoffeeOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderCoffeeMapper orderCoffeeMapper;

    @Override
    public List<OrderCoffee> createOrder(String customer, Coffee...coffee) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Order order = new Order()
                .withCustomer(customer)
                .withCreateTime(new Date())
                .withUpdateTime(new Date())
                .withItems(new ArrayList<>(Arrays.asList(coffee)))
                .withState(OrderState.INIT);
        Long nums = orderMapper.insert(order);
        List<OrderCoffee> list = new ArrayList<>();
        if (nums > 0) {
            Arrays.stream(coffee).forEach(coffee1 -> {
                OrderCoffee orderCoffee = OrderCoffee.builder()
                        .itemsId(coffee1.getId())
                        .coffeeOrderId(order.getId())
                        .build();
                list.add(orderCoffee);
                orderCoffeeMapper.insert(orderCoffee);
            });
        }
        return list;
    }

    @Override
    public Order queryOrder(Long id) {
        return orderMapper.queryOrderById(id);
    }

    /*public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }*/
}
