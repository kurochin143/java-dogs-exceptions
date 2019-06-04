package com.k.restfuldogs

import java.text.SimpleDateFormat
import java.util.*

class ErrorDetails {
    var title: String? = null
    var status: Int = 0
    var detail: String? = null
    private var timestamp: String? = null
    var developerMessage: String? = null
    var errors: HashMap<String, MutableList<ValidationError>> = HashMap()

    fun getTimeStamp(): String? {
        return timestamp
    }

    fun setTimestamp(time: Long) {
        timestamp = SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date(timestamp))
    }
}