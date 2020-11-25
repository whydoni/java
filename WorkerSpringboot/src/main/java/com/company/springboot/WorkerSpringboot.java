package com.company.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.company.springboot"})

public class WorkerSpringboot {

    public static void main(String[] args) {
        SpringApplication.run(WorkerSpringboot.class, args);
    }
}

