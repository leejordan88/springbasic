package kr.co.fastcampus.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("Filter - Hello World");
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String username = (String) session.getAttribute("username");
		
		if(username == null) {
			log.info("new user");
			session.setAttribute("username", "joonsung");
		} else {
			log.info("user -> " + username);
		}
		
		
		chain.doFilter(request, response);
		PrintWriter printWriter = response.getWriter();
		printWriter.println("filter - Hello World");
	}

}
