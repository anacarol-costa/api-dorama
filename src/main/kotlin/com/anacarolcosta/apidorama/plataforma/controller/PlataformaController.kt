package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
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
@RequestMapping("plataformas")
class PlataformaController {

    private val plataformas = mutableListOf<PlataformaModel>()

    @GetMapping
    fun getAllPlataforma(@RequestParam nomePlataforma: String?): List<PlataformaModel> {
        nomePlataforma?.let {
            return plataformas.filter { it.nomePlataforma.contains(nomePlataforma, ignoreCase = true) }
        }
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updatePlataforma(@PathVariable id: String, @RequestBody plataforma: PutPlataformaRequest) {
        plataformas.filter { it.id == id }.first().let {
            it.nomePlataforma = plataforma.nomePlataforma
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlataforma(@PathVariable id: String) {
        plataformas.removeIf { it.id == id }
    }
}