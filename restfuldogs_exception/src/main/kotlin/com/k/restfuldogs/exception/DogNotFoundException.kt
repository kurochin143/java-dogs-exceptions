package com.k.restfuldogs.exception

class DogNotFoundException : ResourceNotFoundException {

    constructor(id: Long) : super("Could not find dog by id: $id")

    constructor(breed: String) : super("Could not find dog breed $breed")
}
