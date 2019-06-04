package com.k.restfuldogs

import com.k.restfuldogs.model.Dog
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration // Indicates a class declares one or more @Beans
class SeedDatabase {

    @Bean
    fun initDB(dogsRepository: DogRepository): CommandLineRunner {
        dogsRepository.save(Dog("Springer", 50, false))
        dogsRepository.save(Dog("Bulldog", 50, true))
        dogsRepository.save(Dog("Collie", 50, false))
        dogsRepository.save(Dog("Boston Terrie", 35, true))
        dogsRepository.save(Dog("Corgie", 35, false))

        return CommandLineRunner { }

//        return { args ->
//            log.info("Seeding " + dogsRepository.save(Dog("Springer", 50, false)))
//            log.info("Seeding " + dogsRepository.save(Dog("Bulldog", 50, true)))
//            log.info("Seeding " + dogsRepository.save(Dog("Collie", 50, false)))
//            log.info("Seeding " + dogsRepository.save(Dog("Boston Terrie", 35, true)))
//            log.info("Seeding " + dogsRepository.save(Dog("Corgie", 35, false)))
//        }

    }
}
