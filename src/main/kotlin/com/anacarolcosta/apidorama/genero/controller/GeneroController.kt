package com.anacarolcosta.apidorama.genero.controller

import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.extension.toGeneroModel
import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.genero.service.GeneroService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("generos")
class GeneroController(
    private val generoService: GeneroService
) {
    @GetMapping
    fun getAllGenero(@RequestParam tipoGenero: String?): List<GeneroModel> {
        return generoService.getAllGenero(tipoGenero)
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