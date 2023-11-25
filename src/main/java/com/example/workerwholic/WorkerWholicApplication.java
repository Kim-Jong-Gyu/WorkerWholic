package com.example.workerwholic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WorkerWholicApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkerWholicApplication.class, args);
    }
}
