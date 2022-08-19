package com.anacarolcosta.apidorama.drama.controller

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.drama.service.DramaService
import com.anacarolcosta.apidorama.extension.toDramaModel
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
class DramaController(
    private val dramaService: DramaService
) {
    @GetMapping
    fun getAllDrama(@RequestParam titulo: String?): List<DramaModel> {
        return dramaService.getAllDrama(titulo)
    }

    @GetMapping("/{id}")
    fun getByIdDrama(@PathVariable id: Int): DramaModel {
        return dramaService.getByIdDrama(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDrama(@RequestBody drama: PostDramaRequest) {
        dramaService.createDrama(drama.toDramaModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDrama(@PathVariable id: Int, @RequestBody drama: PutDramaRequest) {
      dramaService.updateDrama(drama.toDramaModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDrama(@PathVariable id: Int) {
        return dramaService.deleteDrama(id)
    }
}