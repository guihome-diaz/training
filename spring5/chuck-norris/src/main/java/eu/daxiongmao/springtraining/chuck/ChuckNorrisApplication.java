package eu.daxiongmao.springtraining.chuck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
// To inject a set of XML configuration
@ImportResource("classpath*:chuck-library-context.xml")
public class ChuckNorrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuckNorrisApplication.class, args);
	}
}
