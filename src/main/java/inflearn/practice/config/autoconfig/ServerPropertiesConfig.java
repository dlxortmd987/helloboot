package inflearn.practice.config.autoconfig;

import inflearn.practice.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    public ServerProperties serverProperties(Environment environment) {
        ServerProperties properties = new ServerProperties();

        properties.setContextPath(environment.getProperty("contextPath"));
        properties.setPort(environment.getProperty("port", Integer.class));

        return properties;
    }
}
