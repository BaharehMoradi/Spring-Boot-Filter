package com.example.springbootfilter;

import com.example.springbootfilter.filter.RequestResponseLoggingFilter;
import com.example.springbootfilter.filter.TransactionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFilterApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilterUsers(){
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<TransactionFilter> loggingFilterStudents(){
		FilterRegistrationBean<TransactionFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new TransactionFilter());
		registrationBean.addUrlPatterns("/students/*");
		registrationBean.setOrder(2);
		return registrationBean;
	}

}
