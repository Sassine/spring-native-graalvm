package dev.sassine.demo;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class SpringNativeGraalvmApplication {

	public static final String RESPONSE_VALUE = "Spring Native ok !";

	public static void main(String[] args) {
		run(SpringNativeGraalvmApplication.class, args);
	}
	
	@Bean
	RouterFunction<ServerResponse> routes() {
		return route(GET("/"), request -> ok().body(just(RESPONSE_VALUE), String.class));
	}

}
