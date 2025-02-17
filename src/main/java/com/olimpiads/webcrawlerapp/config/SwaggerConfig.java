package com.olimpiads.webcrawlerapp.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI jobCrawlerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Job Crawler API")
                        .description("API documentation for job crawling service")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Diyan Nikolov")
                                .email("didonikolov01@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/DidoNikolovV/job-offers-crawler"));
    }
}
