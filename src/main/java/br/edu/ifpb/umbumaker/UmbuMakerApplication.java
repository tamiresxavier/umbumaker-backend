package br.edu.ifpb.umbumaker;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class UmbuMakerApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(UmbuMakerApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").
		allowedMethods("GET","POST","PUT", "DELETE", "OPTIONS", "PATCH");
		
	}

}