package com.myspring.starbucks.service.impl;

import com.myspring.starbucks.mapper.CoffeeMapper;
import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.model.CoffeeExample;
import com.myspring.starbucks.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/20
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    CoffeeMapper coffeeMapper;

    @Override
    @Cacheable(cacheNames = "coffee_menu",key = "'coffee_'+#id")
    public Coffee queryCoffeeById(Long id) {
        return coffeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Coffee queryCoffeeByName(String name) {
        return coffeeMapper.queryCoffeeByName(name);
    }

    @Override
    @Cacheable(cacheNames = "total_menu",key = "'coffee_list'")
    public List<Coffee> getAllCoffees() {
        CoffeeExample coffeeExample = new CoffeeExample();
        List<Coffee> coffees = coffeeMapper.selectByExample(coffeeExample);
        return coffees;
    }

    @Override
    public List<Coffee> queryCoffeeByName(List<String> names) {
        CoffeeExample coffees = new CoffeeExample();
        coffees.createCriteria().andNameIn(names);
        List<Coffee> coffeeList = coffeeMapper.selectByExample(coffees);
        return coffeeList;
    }
}
