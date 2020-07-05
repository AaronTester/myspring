package com.myspring.starbucks.service;

import com.myspring.starbucks.model.Coffee;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/20
 */
public interface CoffeeService {

    public Coffee queryCoffeeById(Long id);

    public Coffee queryCoffeeByName(String name);

    public List<Coffee> getAllCoffees();

    public List<Coffee> queryCoffeeByName(List<String> names);
}
