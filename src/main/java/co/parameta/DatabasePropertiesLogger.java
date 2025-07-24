package co.parameta;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

public class DatabasePropertiesLogger implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Environment env = applicationContext.getEnvironment();

        System.out.println("============== DATABASE CONFIG (EARLY INIT) ==============");
        System.out.println("spring.datasource.url: " + env.getProperty("spring.datasource.url"));
        System.out.println("spring.datasource.username: " + env.getProperty("spring.datasource.username"));
        System.out.println("spring.datasource.password: " + env.getProperty("spring.datasource.password"));
        System.out.println("===========================================================");
    }
}

