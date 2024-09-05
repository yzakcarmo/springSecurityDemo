package com.yzakcarmo.springsecuritydemo.entities.enums;

public enum UserRole {
    DEFAULT(1),
    ADMIN(2);

    private final int code;

    UserRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserRole valueOf(int code) {
        for (UserRole value : UserRole.values()) {
            if(value.getCode() == code) return value;
        }
        throw new IllegalArgumentException("Codigo invalido");
    }
}
