package tw.brad.stest3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI baseOpenAPI() {
		Info info = new Info();
		info.title("Brad Big Company");
		info.version("v0.1.2");
		info.description("豬皮電子商務");
		
		OpenAPI openAPI = new OpenAPI().info(info);
		return openAPI;
	}
	
}
