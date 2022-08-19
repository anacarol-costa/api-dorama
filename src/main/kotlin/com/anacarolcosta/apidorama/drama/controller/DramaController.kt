package com.anacarolcosta.apidorama.drama.controller

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dramas")
class DramaController {

    val dramas = mutableListOf<DramaModel>()

    @GetMapping
    fun getAllDrama(@RequestParam titulo: String?): List<DramaModel> {
        titulo?.let {
            return dramas.filter { it.titulo.contains(titulo, ignoreCase = true) }
        }
        return dramas
    }

    @GetMapping("/{id}")
    fun getByIdDrama(@PathVariable id: Int): DramaModel {
        return dramas.filter { it.id == id }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDrama(@RequestBody drama: PostDramaRequest) {
        val id = if (dramas.isEmpty()) {
            1
        } else {
            dramas.last().id!! + 1
        }

        dramas.add(DramaModel(id, drama.titulo, drama.anoLancamento, drama.temporadas, drama.quantidadeEpisodios, drama.genero, drama.plataforma))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDrama(@PathVariable id: Int, @RequestBody drama: PutDramaRequest) {
        dramas.filter { it.id == id }.first().let {
            it.titulo = drama.titulo
            it.anoLancamento = drama.anoLancamento
            it.temporadas = drama.temporadas
            it.quantidadeEpisodios = drama.quantidadeEpisodios
            it.genero= drama.genero
            it.plataforma = drama.plataforma

        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDrama(@PathVariable id: Int) {
        dramas.removeIf { it.id == id }
    }
}