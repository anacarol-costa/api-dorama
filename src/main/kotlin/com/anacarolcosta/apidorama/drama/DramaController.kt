package com.anacarolcosta.apidorama.drama

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dramas")
class DramaController {

    val drama = mutableListOf<DramaModel>()

    @GetMapping
    fun getAllDrama(): MutableList<DramaModel> {
        return drama
    }

    @PostMapping
    fun createDrama(@RequestBody drama: PostDramaRequest) {
        println(drama)
    }

}