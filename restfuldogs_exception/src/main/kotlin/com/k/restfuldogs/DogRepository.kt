package com.k.restfuldogs

import com.k.restfuldogs.model.Dog
import org.springframework.data.jpa.repository.JpaRepository

interface DogRepository : JpaRepository<Dog, Long>
