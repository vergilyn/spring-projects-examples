package com.vergilyn.examples;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserInfo implements Serializable {

    private final String name;

    public UserInfo(String name) {
        this.name = name;
    }
}
