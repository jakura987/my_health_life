package com.itgroup.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt.token")
@Data
public class JwtProperties {
    /**
     * related configuration
     */
    private String name;
    private long expiry;
}
