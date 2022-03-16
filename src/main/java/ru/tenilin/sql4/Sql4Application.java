package ru.tenilin.sql4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Sql4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sql4Application.class, args);
    }

}
