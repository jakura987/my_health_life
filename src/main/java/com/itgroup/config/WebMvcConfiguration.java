package com.itgroup.config;

import com.itgroup.interceptor.JwtTokenAdminInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

    /**
     * Interceptor
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenAdminInterceptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/user/login","/admin/user/register",
                        "/admin/food/**","/admin/food", "/admin/product/**");
    }

    /**
     * cross domain
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // allow all path
                .allowedOrigins("http://localhost:3000") // all request from localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")// Allowed HTTP methods
                .allowedHeaders("*");  // Allow all headers
    }

    /**
     * 接口文档
     * @return
     */
    @Bean
    public Docket docket() {
        log.info("Preparing to generate API documentation...");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("myHealthLife API")
                .version("2.0")
                .description("Recording input, output, and other information for all server interfaces here.")
                .contact(new Contact("Bob", "http://bob123.com","jakuradyhdyh@gmail.com"))
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //Specify the package to scan for generating interfaces
                .apis(RequestHandlerSelectors.basePackage("com.itgroup.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * Configure static resource mapping
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("start configuring static resource mapping...");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}




