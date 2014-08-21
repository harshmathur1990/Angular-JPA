package com.harmathuwebLogin;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan
@EnableJpaRepositories
@PropertySource(value = { "classpath:application.properties" })
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
				Application.class, args);

		UsersRepository repoUser = context.getBean(UsersRepository.class);
		Users harsh = new Users("Harsh", "Mathur", "harmathu", "blahblah");
		repoUser.save(harsh);
		/*
		 * SessionRepository session_user =
		 * context.getBean(SessionRepository.class); Sessions session_harsh =
		 * new Sessions(harsh, new GregorianCalendar(2014, 8, 14, 11, 45, 43),
		 * GregorianCalendar.getInstance()); session_user.save(session_harsh);
		 * String body = "{\"sessionId\" : \"" + session_harsh.getSessionId() +
		 * "\", \"firstName\" : \"" + harsh.getFirstName() +
		 * "\", \"lastName\" : \"" + harsh.getLastName() + "\"}";
		 * System.out.println(body);
		 */
	}

}
