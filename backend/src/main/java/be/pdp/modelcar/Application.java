package be.pdp.modelcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by peterdp on 02/10/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "be.pdp.modelcar")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
