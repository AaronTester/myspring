package com.spring.jdbc;

import com.spring.jdbc.entry.User;
import com.spring.jdbc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
class JdbcApplicationTests {
    private Logger logger = LoggerFactory.getLogger(JdbcApplicationTests.class);
    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
        System.out.println("清空user表");
    }

    @Test
    public void test() throws Exception {
        logger.info("查询用户：");
        List<User> allUsers = userService.getAllUsers();
        logger.info("查询结果：{}"+allUsers);
    }

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from tbl_user where id = 2 ");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("last_name");
            System.out.println(cityName);
        }
    }


}
