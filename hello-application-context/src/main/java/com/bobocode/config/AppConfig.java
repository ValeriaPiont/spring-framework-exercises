package com.bobocode.config;

import com.bobocode.TestDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class application context configuration.
 */

@Configuration
@ComponentScan(basePackages = {"com.bobocode.dao", "com.bobocode.service"})
public class AppConfig {

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }

}
