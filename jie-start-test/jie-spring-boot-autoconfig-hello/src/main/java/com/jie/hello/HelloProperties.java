package com.jie.hello;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix ="jie.hello")
public class HelloProperties {

	private String prefix;

	private String suffix;
}
