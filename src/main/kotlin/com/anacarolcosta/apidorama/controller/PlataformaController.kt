package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.model.PlataformaModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("plataformas")
class PlataformaController {

    private val plataformas = mutableListOf<PlataformaModel>()

    @GetMapping
    fun getAllPlataforma(): MutableList<PlataformaModel> {
        return plataformas
    }

    @GetMapping("/{id}")
    fun getPlataforma(@PathVariable id: String): PlataformaModel {
        return plataformas.filter { it.id == id }.first()
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody plataforma: PostPlataformaRequest) {
        val id =  if (plataformas.isEmpty()) {
            1
        } else {
            plataformas.last().id.toInt() + 1
        }.toString()

        plataformas.add(PlataformaModel(id, plataforma.nomePlataforma))
    }
}