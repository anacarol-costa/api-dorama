package com.anacarolcosta.apidorama.plataforma.exception

import com.anacarolcosta.apidorama.plataforma.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class PlataformaControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleExceptionPlataforma(ex: NotFoundException,  request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            errors = null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
}