package com.m223isi.microservice.apigateway.Configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter (RouteLocatorBuilder builder){ 
		/*Function<PredicateSpec, Buildable<Route>> routeFunction = 
				p -> p.path("/get").uri("http://httpbin.org:80"); 
			
			return builder.routes()
			.route(routeFunction) 
			.build();
			}
*/
			return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("myHearderParam", "headerParamValue")
								.addRequestParameter("MyParameter", "ParamValue")
								)
						.uri("http://httpbin.org:80")) 
				.build();
				}
}
