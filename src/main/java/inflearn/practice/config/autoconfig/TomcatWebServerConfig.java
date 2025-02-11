package inflearn.practice.config.autoconfig;

import inflearn.practice.config.ConditionalMyOnClass;
import inflearn.practice.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Value("${contextPath:}")
    String contextPath;

    @Value("${port:8080}")
    int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.setContextPath(this.contextPath);
        factory.setPort(this.port);

        return factory;
    }
}
