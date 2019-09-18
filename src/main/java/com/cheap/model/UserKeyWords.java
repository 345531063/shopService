package com.cheap.model;

import lombok.Data;

@Data
public class UserKeyWords {

    // 获取多少个关键字
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
