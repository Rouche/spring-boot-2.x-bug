package com.test.config;

import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jean-Francois Larouche jealar2 on 2018-08-22
 */
@Getter
public class UserAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 6698231753971757890L;

    private final String authority;

    @JsonCreator
    public UserAuthority(@JsonProperty("authority") String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
