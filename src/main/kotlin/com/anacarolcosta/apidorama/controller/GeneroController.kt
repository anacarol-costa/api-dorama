package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.extension.toGeneroModel
import com.anacarolcosta.apidorama.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.model.GeneroModel
import com.anacarolcosta.apidorama.service.GeneroService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("generos")
class GeneroController(
    private val generoService: GeneroService
) {
    @GetMapping
    fun getAllGenero(): List<GeneroModel> {
        return generoService.getAllGenero()
    }

    @GetMapping("/{id}")
    fun getByIdGenero(@PathVariable id: Int): GeneroModel {
        return generoService.getByIdGenero(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGenero(@RequestBody @Valid genero: PostGeneroRequest) {
        generoService.createGenero(genero.toGeneroModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateGenero(@PathVariable id: Int, @RequestBody genero: PutGeneroRequest) {
        generoService.updateGenero(genero.toGeneroModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteGenero(@PathVariable id: Int) {
        return generoService.deleteGenero(id)
    }

}