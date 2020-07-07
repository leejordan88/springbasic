package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class A {
	@Value("${catalog.name}") String name;
	
	public void init() {
		log.info("A post constructor " + name);
	}
	
	public void destroy() {
		log.info("A pre destroy");
	}
	
}
