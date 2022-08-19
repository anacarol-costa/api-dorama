package com.anacarolcosta.apidorama.drama.service

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class DramaService {

    val drama = mutableListOf<DramaModel>()

    fun getAllDrama(): MutableList<DramaModel> {
        return drama
    }

    fun createDrama(@RequestBody drama: PostDramaRequest) {
        println(drama)
    }
}