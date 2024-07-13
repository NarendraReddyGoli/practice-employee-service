package com.microservices.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import com.microservices.employee.client.DepartmentClient;

@Configuration
public class WebClientConfig {

	@Autowired
	private LoadBalancedExchangeFilterFunction filter;

	@Bean
	WebClient getDeptWebClinet() {
		return WebClient.builder().baseUrl("http://department-service").filter(filter).build();
	}

	@SuppressWarnings("removal")
	@Bean
	DepartmentClient deptClient() {
		HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(getDeptWebClinet())).build();

		return proxyFactory.createClient(DepartmentClient.class);
	}

}
