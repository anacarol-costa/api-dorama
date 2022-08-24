package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.extension.toPlataformaModel
import com.anacarolcosta.apidorama.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.model.PlataformaModel
import com.anacarolcosta.apidorama.service.PlataformaService
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
import javax.validation.Valid

@RestController
@RequestMapping("plataformas")
class PlataformaController(
    private val plataformaService: PlataformaService
) {

    @GetMapping
    fun getAllPlataforma(@RequestParam nomePlataforma: String?): List<PlataformaModel> {
        return plataformaService.getAllPlataforma(nomePlataforma)
    }

    @GetMapping("/{id}")
    fun getPlataforma(@PathVariable id: Int): PlataformaModel {
        return plataformaService.getByIdPlataforma(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPlataforma(@RequestBody @Valid plataforma: PostPlataformaRequest) {
        plataformaService.createPlataforma(plataforma.toPlataformaModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updatePlataforma(@PathVariable id: Int, @RequestBody plataforma: PutPlataformaRequest) {
        plataformaService.updatePlataforma(plataforma.toPlataformaModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlataforma(@PathVariable id: Int) {
        return plataformaService.deletePlataforma(id)
    }
}