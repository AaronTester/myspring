package com.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class JdbcApplication  {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

}
