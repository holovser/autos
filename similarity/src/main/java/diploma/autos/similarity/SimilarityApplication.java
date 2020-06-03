package diploma.autos.similarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimilarityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimilarityApplication.class, args);
	}

}
