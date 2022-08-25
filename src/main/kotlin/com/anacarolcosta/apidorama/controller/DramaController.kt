package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.model.DramaModel
import com.anacarolcosta.apidorama.service.DramaService
import com.anacarolcosta.apidorama.extension.toDramaModel
import com.anacarolcosta.apidorama.service.GeneroService
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
import java.util.Objects
import javax.validation.Valid

@RestController
@RequestMapping("dramas")
class DramaController(
    private val dramaService: DramaService,
    private val generoService: GeneroService,
    private val plataformaService: PlataformaService
) {
    @GetMapping
    fun getAllDrama(): List<DramaModel> {
        return dramaService.getAllDrama()
    }

    @GetMapping("/{id}")
    fun getByIdDrama(@PathVariable id: Int): DramaModel {
        return dramaService.getByIdDrama(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDrama(@RequestBody @Valid request: PostDramaRequest) {
        val genero = generoService.findById(request.generoId)
        val plataforma = plataformaService.findById(request.plataformaId)

        dramaService.createDrama(request.toDramaModel(genero, plataforma))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDrama(@PathVariable id: Int, @RequestBody @Valid drama: PutDramaRequest) {
        val dramaSaved = dramaService.findById(id = id)
        val plataforma = plataformaService.findById(drama.plataformaId)
        val genero = generoService.findById(drama.generoId)

        if(Objects.isNull(dramaSaved)) throw Exception("Drama não existe.")

        dramaService.updateDrama(drama.toDramaModel(genero, plataforma))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDrama(@PathVariable id: Int) {
        return dramaService.deleteDrama(id)
    }
}