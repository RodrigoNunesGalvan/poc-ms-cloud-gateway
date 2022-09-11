package br.com.a2like.pocmscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PocMsCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocMsCloudGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder
				.routes()
					.route(r -> r.path("/clientes/**").uri("lb://poc-ms-clientes"))
				.build();
	}

}
