package com.k.restfuldogs.model

import com.fasterxml.jackson.annotation.JsonProperty

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Dog {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    var id: Long = 0

    @JsonProperty("breed")
    var breed: String? = null

    @JsonProperty("weight")
    var weight: Int = 0

    @JsonProperty("apartment")
    var canApartment: Boolean = false

    constructor()

    constructor(breed: String, weight: Int, canApartment: Boolean) {
        this.breed = breed
        this.weight = weight
        this.canApartment = canApartment
    }

}
