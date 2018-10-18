package com.zhum.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("com.zhum.demo.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class Application extends SpringBootServletInitializer {


//	public static void main(String[] args) {
//		SpringApplication.run(Application.class);
//	}



	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public EmbeddedServletContainerCustomizer CustomizerError(){
		return new EmbeddedServletContainerCustomizer(){

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404"));
				container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/400"));
				container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500"));
				container.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,"/405"));
				container.setSessionTimeout(60, TimeUnit.SECONDS);


			}
		};

	}

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}
