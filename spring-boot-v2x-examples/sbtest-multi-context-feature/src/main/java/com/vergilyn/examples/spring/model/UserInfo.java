package com.vergilyn.examples.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Long id;

    private String name;

    private LocalDateTime createTime = LocalDateTime.now();

}
