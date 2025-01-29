package inflearn.practice.helloboot;

import inflearn.practice.config.autoconfig.DispatcherServletConfig;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
@Import({DispatcherServletConfig.class, TomcatServletWebServerFactory.class})
public @interface MySpringBootApplication {
}
