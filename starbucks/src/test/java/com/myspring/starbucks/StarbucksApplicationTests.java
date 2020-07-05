package com.myspring.starbucks;

import com.myspring.starbucks.mapper.CoffeeMapper;
import com.myspring.starbucks.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@MapperScan("com.myspring.starbucks.mapper")
class StarbucksApplicationTests {

    @Autowired
    CoffeeMapper coffeeMapper;

    public void testRedis() {
        log.info("line 43 query DataBase");
        Coffee coffee = coffeeMapper.selectByPrimaryKey((long) 1);
        log.info("query result:{}",coffee);
    }

}
