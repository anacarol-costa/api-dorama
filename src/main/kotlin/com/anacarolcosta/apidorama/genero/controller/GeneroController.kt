package com.anacarolcosta.apidorama.genero.controller

import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("generos")
class GeneroController {

    var genero = mutableListOf<GeneroModel>()

    @GetMapping
    fun getAllGenero(): MutableList<GeneroModel> {
        return genero
    }

    @PostMapping
    fun createGenero(@RequestBody genero: PostGeneroRequest) {
        println(genero)
    }
}