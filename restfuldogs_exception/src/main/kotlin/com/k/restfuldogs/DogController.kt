package com.k.restfuldogs

import com.k.restfuldogs.exception.DogNotFoundException
import com.k.restfuldogs.model.Dog
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DogController(private val dogRepository: DogRepository) {

    @GetMapping("/dogs")
    fun all(): ResponseEntity<*> {
        val dogs = dogRepository.findAll()

        return ResponseEntity(dogs, HttpStatus.OK)
    }

    @GetMapping("/dogs/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<*> {
        val dog = dogRepository.findById(id)
                .orElseThrow { DogNotFoundException(id) }

        return ResponseEntity(dog, HttpStatus.OK)
    }

    // returns a listing of all dogs ordered by breed
    @GetMapping("/dogs/breeds")
    fun getDogsSortedByBreed(): ResponseEntity<*> {
        val dogs = mutableListOf<Dog>()

        dogs.addAll(dogRepository.findAll())

        dogs.sortBy {
            it.breed
        }

        return ResponseEntity(dogs, HttpStatus.OK)
    }

    // returns a listing of all dogs ordered by average weight
    @GetMapping("/dogs/weight")
    fun getDogsSortedByWeight(): ResponseEntity<*> {
        val dogs = mutableListOf<Dog>()

        dogs.addAll(dogRepository.findAll())

        dogs.sortBy {
            it.weight
        }

        return ResponseEntity(dogs, HttpStatus.OK)
}

    // returns dogs of just that breed
    @GetMapping("/dogs/breeds/{breed}")
    fun getDogByBreed(@PathVariable breed: String): ResponseEntity<*> {
        var dog: Dog? = null
        dogRepository.findAll().forEach {
            if (it.breed == breed) {
                dog = it
                return@forEach
            }
        }

        if (dog == null) throw DogNotFoundException(breed)

        return ResponseEntity(dog, HttpStatus.OK)
    }

    // returns dogs suitable for apartments
    @GetMapping("/dogs/apartment")
    fun getDogsCanApartment(): ResponseEntity<*> {
        val dogs = mutableListOf<Dog>()

        dogRepository.findAll().forEach {
            if (it.canApartment) {
                dogs.add(it)
            }
        }

        return ResponseEntity(dogs, HttpStatus.OK)
    }


}
