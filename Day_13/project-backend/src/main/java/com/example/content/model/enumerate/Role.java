package com.example.content.model.enumerate;

import static com.example.content.model.enumerate.Permission.ADMIN_CREATE;
import static com.example.content.model.enumerate.Permission.ADMIN_DELETE;
import static com.example.content.model.enumerate.Permission.ADMIN_READ;
import static com.example.content.model.enumerate.Permission.ADMIN_UPDATE;
import static com.example.content.model.enumerate.Permission.USER_CREATE;
import static com.example.content.model.enumerate.Permission.USER_DELETE;
import static com.example.content.model.enumerate.Permission.USER_READ;
import static com.example.content.model.enumerate.Permission.USER_UPDATE;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
            ADMIN_READ,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            USER_READ,
            USER_CREATE,
            USER_UPDATE,
            USER_DELETE)),
    USER(Set.of(
            USER_READ,
            USER_CREATE,
            USER_UPDATE,
            USER_DELETE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Permission permission : getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
