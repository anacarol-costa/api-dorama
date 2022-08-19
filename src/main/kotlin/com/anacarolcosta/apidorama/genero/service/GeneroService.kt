package com.anacarolcosta.apidorama.genero.service

import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class GeneroService {

    val genero = mutableListOf<GeneroModel>()

    fun getAllGenero(): MutableList<GeneroModel> {
        return genero
    }

    fun createGenero(@RequestBody genero: PostGeneroRequest) {
        println(genero)
    }
}