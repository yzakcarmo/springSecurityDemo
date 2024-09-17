package com.yzakcarmo.springsecuritydemo.entities.records;

import com.yzakcarmo.springsecuritydemo.entities.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
