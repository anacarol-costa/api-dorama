package com.anacarolcosta.apidorama.drama.controller

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dramas")
class DramaController {

    val dramas = mutableListOf<DramaModel>()

    @GetMapping
    fun getAllDrama(): MutableList<DramaModel> {
        return dramas
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
}