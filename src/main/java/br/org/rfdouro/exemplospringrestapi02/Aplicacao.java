/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 *
 * @author romulo.douro
 */
@SpringBootApplication
public class Aplicacao {

 public static void main(String[] args) {
  SpringApplication.run(Aplicacao.class, args);
 }

 /*
	 * objeto gerenciado pelo Spring que adiciona informações à documentação
		* essas informações são adicionadas à página do swagger
	 */
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Servidor de cadastro - DEMO.")
						.version("1.0.0")
						.contact(new Contact().email("rfdouro@gmail.com").name("Rômulo F. Douro"))
						.description("<h1>Exemplo de REST API com cadastro de pessoas</h1><p>Código disponível no "
						+ "<a href='https://github.com/rfdouro/ExemploSpringRestAPI' target='_blank'>Github</a></p>"));
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")  // Permite todas origens
                        .allowedMethods("*")   // Permite todos métodos (GET, POST, etc)
                        .allowedHeaders("*");  // Permite todos headers
            }
        };
    }
}
