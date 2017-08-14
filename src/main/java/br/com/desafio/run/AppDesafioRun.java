package br.com.desafio.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author Luciano
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("br.com.desafio.*")
public class AppDesafioRun {

	public static void main(String[] args) {
		SpringApplication.run(AppDesafioRun.class, args);
    }
}

