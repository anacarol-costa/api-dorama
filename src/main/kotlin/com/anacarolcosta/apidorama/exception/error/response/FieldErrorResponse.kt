package com.anacarolcosta.apidorama.exception.error.response

data class FieldErrorResponse (
    var message: String,
    var field: String
)