package com.example.goods.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User_address implements Serializable {
    private int user_a_id;
    private String user_a_name;
    private String user_a_phone;
    private String user_a_address;
    private int users_id;
}
