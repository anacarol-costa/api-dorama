package com.anacarolcosta.apidorama.genero.controller

import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("generos")
class GeneroController {

    var generos = mutableListOf<GeneroModel>()

    @GetMapping
    fun getAllGenero(): MutableList<GeneroModel> {
        return generos
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGenero(@RequestBody genero: PostGeneroRequest) {
        val id = if (generos.isEmpty()) {
            1
        } else {
            generos.last().id!! + 1
        }

        generos.add(GeneroModel(id, genero.tipoGenero))
    }

}