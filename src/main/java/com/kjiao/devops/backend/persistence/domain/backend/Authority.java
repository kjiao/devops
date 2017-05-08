package com.kjiao.devops.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by kjiao on 08/05/2017.
 */
public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
