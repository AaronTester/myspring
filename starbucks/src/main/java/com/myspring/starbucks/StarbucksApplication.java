package com.myspring.starbucks;

import com.github.pagehelper.PageInfo;
import com.myspring.starbucks.mapper.CoffeeMapper;
import com.myspring.starbucks.model.Coffee;
import com.myspring.starbucks.model.CoffeeExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableCaching
public class StarbucksApplication {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(StarbucksApplication.class, args);
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {
		queryCatchCoffee();
    }*/

    public void queryCatchCoffee() throws Exception {
        log.info("line 43 query DataBase");
        Coffee coffee = coffeeMapper.selectByPrimaryKey((long) 1);
        log.info("query result:{}",coffee);
    }

    public void pageHelper() {
        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 5))
                .forEach(c -> log.info("Page(1) Coffee {}", c));
        log.info("============s===================================================");

        coffeeMapper.findAllWithRowBounds(new RowBounds(2, 5))
                .forEach(c -> log.info("Page(2) Coffee {}", c));
        log.info("===============================================================");

        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(c -> log.info("Page(1) Coffee {}", c));
        log.info("===============================================================");

        coffeeMapper.findAllWithParam(1, 3)
                .forEach(c -> log.info("Page(1) Coffee {}", c));
        List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
        PageInfo page = new PageInfo(list);
        log.info("PageInfo: {}", page);
    }

    public void playWithArtifacts() {
        Coffee espresso = new Coffee()
                .withName("espresso")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(espresso);

        Coffee latte = new Coffee()
                .withName("latte")
                .withPrice(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .withCreateTime(new Date())
                .withUpdateTime(new Date());
        coffeeMapper.insert(latte);

        Coffee s = coffeeMapper.selectByPrimaryKey(1L);
        log.info("Coffee {}", s);

        CoffeeExample example = new CoffeeExample();
        example.createCriteria().andNameEqualTo("latte");
        List<Coffee> list = coffeeMapper.selectByExample(example);
        list.forEach(e -> log.info("selectByExample: {}", e));
    }
}

