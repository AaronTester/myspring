package com.spring.jdbc.service.impl;

import com.spring.jdbc.entry.User;
import com.spring.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into employee(NAME, AGE ) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(Integer id) {
        jdbcTemplate.update("delete from employee where id = ?", id);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select id,email,last_name from tbl_user where id < 20", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                /*User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setLast_name(resultSet.getString(3));*/
                return User.builder()
                        .id(resultSet.getInt(1))
                        .email(resultSet.getString(2))
                        .last_name(resultSet.getString(3))
                        .build();
            }
        });
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from employee");
    }
}
