package com.anacarolcosta.apidorama.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {
}