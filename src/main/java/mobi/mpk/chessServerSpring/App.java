package mobi.mpk.chessServerSpring;

import mobi.mpk.chessServerSpring.registry.UserRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public UserRegistry<String, User> createUserRegistry() {
		return new UserRegistry<>();
	}

}
