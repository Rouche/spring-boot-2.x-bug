package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author syduch
 *
 */
@Configuration
public class PropertiesConfig {

    @Configuration
    @Profile({"dev"})
    @PropertySource({"classpath:datasource-config-dev.properties"})
    public static class ConfigDev {
    }
}
