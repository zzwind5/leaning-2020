package com.jie.hello.config;

import com.jie.hello.HelloProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({HelloProperties.class})
@ComponentScan("com.jie.hello.config")
public class HelloAutoConfig {

}
