package com.cheap.model;

import lombok.Data;

@Data
public class UserModel {
    public  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
