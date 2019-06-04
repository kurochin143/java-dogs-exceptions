package com.k.restfuldogs

class ValidationError {

    var code: String? = null
    var message: String? = null

    constructor()

    constructor(code: String, message: String) {
        this.code = code
        this.message = message
    }


}