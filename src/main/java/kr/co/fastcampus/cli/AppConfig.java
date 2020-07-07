package kr.co.fastcampus.cli;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public A a() {
		return new A();
	}
	
	@Bean
	public B b() {
		return new B();
	}
	
	
}
