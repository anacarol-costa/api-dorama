package com.anacarolcosta.apidorama.plataforma.exception

import com.anacarolcosta.apidorama.plataforma.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class PlataformaControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleExceptionPlataforma(ex: java.lang.Exception,  request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            httpCode = 400,
            message = "Esta plataforma não existe!",
            internalCode = "0001",
            errors = null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
}