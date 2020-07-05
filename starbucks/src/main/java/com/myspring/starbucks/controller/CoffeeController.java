package com.myspring.starbucks.controller;

import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/20
 */
@RestController
@Slf4j
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/queryCoffeeById/{id}")
    public Coffee queryCoffeeById(@PathVariable("id") Long id){
        return  coffeeService.queryCoffeeById(id);
    }

    @GetMapping("/queryCoffeeByName/{name}")
    public Coffee queryCoffeeByName(@PathVariable("name") String name) {
        return coffeeService.queryCoffeeByName(name);
    }

    @GetMapping("/queryAllCoffees")
    public List<Coffee>  queryAllCoffee() {
        return coffeeService.getAllCoffees();
    }
}
