package com.anacarolcosta.apidorama.genero.controller

import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("generos")
class GeneroController {

    var generos = mutableListOf<GeneroModel>()

    @GetMapping
    fun getAllGenero(@RequestParam tipoGenero: String?): List<GeneroModel> {
        tipoGenero?.let {
            return generos.filter { it.tipoGenero.contains(tipoGenero, ignoreCase = true) }
        }
        return generos
    }

    @GetMapping("/{id}")
    fun getByIdGenero(@PathVariable id: Int): GeneroModel {
        return generos.filter { it.id == id }.first()
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateGenero(@PathVariable id: Int, @RequestBody genero: PutGeneroRequest) {
        generos.filter { it.id == id }.first().let {
            it.tipoGenero = genero.tipoGenero
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteGenero(@PathVariable id: Int) {
        generos.removeIf { it.id == id }
    }

}