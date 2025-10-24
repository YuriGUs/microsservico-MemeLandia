package meme_service.api_meme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMemeApplication.class, args);
	}

}
