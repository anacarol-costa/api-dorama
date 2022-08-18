package com.anacarolcosta.apidorama.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}