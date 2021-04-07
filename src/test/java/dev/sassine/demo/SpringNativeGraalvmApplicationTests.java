package dev.sassine.demo;

import static dev.sassine.demo.SpringNativeGraalvmApplication.RESPONSE_VALUE;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.reactive.context.ReactiveWebApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
class SpringNativeGraalvmApplicationTests {

	private WebTestClient webTestClient;

	@BeforeEach
	void beforeEach(ReactiveWebApplicationContext context) {
		webTestClient = WebTestClient.bindToApplicationContext(context).configureClient().build();
	}

	@Test
	void whenGetBooksThenReturn() {
		webTestClient.get().uri("/").exchange().expectStatus().is2xxSuccessful().expectBody(String.class).isEqualTo(RESPONSE_VALUE);
	}
}