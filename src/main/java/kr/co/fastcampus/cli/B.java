package kr.co.fastcampus.cli;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class B {
	@Value("${catalog.name}") String name;
	
	@PostConstruct
	public void init() {
		log.info("B post constructor " + name);
	}
	
	@PreDestroy
	public void destroy() {
		log.info("B pre destroy");
	}
	
}
