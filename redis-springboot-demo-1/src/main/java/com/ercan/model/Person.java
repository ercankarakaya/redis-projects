package com.ercan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Person")
@Data
public class Person implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;

}
