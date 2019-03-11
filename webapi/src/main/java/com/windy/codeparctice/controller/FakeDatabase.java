package com.windy.codeparctice.controller;

import org.springframework.stereotype.Component;

@Component
public class FakeDatabase {

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private Long count = 1000L;

}
