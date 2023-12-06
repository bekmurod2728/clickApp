package uz.click;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "uz")
public class ClickAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickAppApplication.class, args);
    }

}
