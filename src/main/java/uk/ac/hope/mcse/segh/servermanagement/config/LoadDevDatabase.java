package uk.ac.hope.mcse.segh.servermanagement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/*
@Configuration
class LoadDevDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDevDatabase.class);

    @Bean
    @Profile("dev")
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Diana","Spencer", 21,  "Princess")));
            log.info("Preloading " + repository.save(new Employee("Fred", "Bloggs", 55, "Bricklayer")));
            // Make up some other people here ...
        };
    }
}
*/