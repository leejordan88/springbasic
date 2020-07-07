package kr.co.fastcampus.cli;

import java.sql.SQLException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class, excludeFilters = @Filter(type=FilterType.REGEX, pattern = "kr.co.fastcampus.cli.B"))
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		log.info("Hello World");
//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		
		Dao dao = context.getBean(Dao.class);
		dao.run();
		
		context.close();
		
	}
}
