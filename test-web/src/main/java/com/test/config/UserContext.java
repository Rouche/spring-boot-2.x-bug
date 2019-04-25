package com.test.config;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jean-Francois Larouche jealar2 on 2018-08-22
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserContext extends User implements UserDetails {

    private static final long serialVersionUID = 6698231753971757890L;

    public static final String COOKIE_BEARER_HEADER_PAYLOAD = "COOKIE-BEARER.h.p";
    public static final String COOKIE_BEARER_SIGNATURE = "COOKIE-BEARER.s";

    private String userUUID;
    private String fullName;
    private String email;
    private String userNumber;

    @JsonCreator
    public UserContext(@JsonProperty("userUUID") String userUUID,
                       @JsonProperty("fullName") String fullName,
                       @JsonProperty("email") String email,
                       @JsonProperty("userNumber") String userNumber,
                       @JsonProperty("username") String username,
                       @JsonProperty("enabled") boolean enabled,
                       @JsonProperty("accountNonExpired") boolean accountNonExpired,
                       @JsonProperty("credentialsNonExpired") boolean credentialsNonExpired,
                       @JsonProperty("accountNonLocked") boolean accountNonLocked,
                       @JsonProperty("authorities") Collection<UserAuthority> authorities) {
        super(username, "", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.userUUID = userUUID;
        this.fullName = fullName;
        this.email = email;
        this.userNumber = userNumber;
    }

    public UserContext(String userUUID,
                       String fullName,
                       String email,
                       String userNumber,
                       String username,
                       String password,
                       @JsonProperty("authorities") Collection<UserAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);

        this.userUUID = userUUID;
        this.fullName = fullName;
        this.email = email;
        this.userNumber = userNumber;
    }
}
