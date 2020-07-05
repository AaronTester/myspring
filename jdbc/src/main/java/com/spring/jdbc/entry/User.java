package com.spring.jdbc.entry;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/14
 */
@Data
@Builder(toBuilder = true)
public class User {
    private Integer id;
    private String email;
    private String last_name;

    @Tolerate
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
