package com.dzh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(Integer id, String name, Integer password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(Integer id, String name, Integer password, String test) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.test = test;
    }

    private Integer id;
    private String name;
    private Integer password;

    private String test;

    private List<Car> list;
    private Map<String,Car> map;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime birthDay;

}
