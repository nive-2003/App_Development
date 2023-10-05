package com.example.content.model.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    USER_READ("customer:read"),
    USER_UPDATE("customer:update"),
    USER_CREATE("customer:create"),
    USER_DELETE("customer:delete");

    @Getter
    private final String permission;
}
