package com.anacarolcosta.apidorama.controller

import com.anacarolcosta.apidorama.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.model.PlataformaModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("plataformas")
class PlataformaController {

    @GetMapping
    fun getPlataforma(): PlataformaModel {
        return PlataformaModel("1", "Netflix")
    }

    @PostMapping
    fun create(@RequestBody plataforma: PostPlataformaRequest) {
        println(plataforma)
    }
}