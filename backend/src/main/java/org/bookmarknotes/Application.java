package org.bookmarknotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by zealot on 08.08.18.
 */

@SpringBootApplication
@ComponentScan("org.bookmarknotes")
@EnableJpaRepositories("org.bookmarknotes.repository")
@EntityScan("org.bookmarknotes.entities")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
