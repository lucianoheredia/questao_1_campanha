package br.com.desafio.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import br.com.desafio.kafka.impl.MensagemConsumer;
import br.com.desafio.kafka.impl.RunConsumer;
/**
 * 
 * @author Luciano
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("br.com.desafio.*")
public class AppDesafioRun {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(AppDesafioRun.class, args);
		
		MensagemConsumer mensCon = new MensagemConsumer();
		RunConsumer run = new RunConsumer(mensCon, "ENVIO_FILA_CAMP");
		run.run();
		
    }
}

