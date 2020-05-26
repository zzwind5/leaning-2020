package com.demo.cookie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@EnableRedisHttpSession
@SpringBootApplication
public class DemoMain {

	public static void main(String[] args) {
		SpringApplication.run(DemoMain.class);
	}

	@Bean
	public CookieSerializer cookieSerializer() {

		// 默认 Cookie 序列化
		DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();

		// Cookie名字，默认为 SESSION
		defaultCookieSerializer.setCookieName("SESSION_ID");

		// 域，这允许跨子域共享cookie，默认设置是使用当前域。
		defaultCookieSerializer.setDomainName("zhang.com");

		// Cookie的路径。
		defaultCookieSerializer.setCookiePath("/");

		return defaultCookieSerializer;
	}
}
