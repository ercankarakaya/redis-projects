package com.ercan;

import com.ercan.model.Person;
import com.ercan.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisSpringbootDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringbootDemo1Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(PersonRepository personRepository) {
        return args -> {
            Person person = new Person();
            person.setId("123ABC");
            person.setFirstName("John");
            person.setLastName("Wick");
            person.setAge(40);

            personRepository.save(person);
            Person personSaved = personRepository.findById("123ABC").orElse(null);
            System.out.println(personSaved);
        };
    }

}
