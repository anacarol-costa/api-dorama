package com.anacarolcosta.apidorama.plataforma.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}