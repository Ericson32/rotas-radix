package org.radix.rotas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="org.radix.rotas")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
