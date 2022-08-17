package com.anacarolcosta.apidorama.plataforma.service

import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class PlataformaService {

    private val plataformas = mutableListOf<PlataformaModel>()

    fun getAllPlataforma(nomePlataforma: String?): List<PlataformaModel>{
        nomePlataforma?.let {
            return plataformas.filter { it.nomePlataforma.contains(nomePlataforma, ignoreCase = true) }
        }
        return plataformas
    }

    fun getPlataforma(id: String): PlataformaModel {
        return plataformas.filter { it.id == id }.first()
    }

    fun createPlataforma(plataforma: PostPlataformaRequest) {
        val id = if (plataformas.isEmpty()) {
            1
        } else {
            plataformas.last().id.toInt() +1
        }.toString()

        plataformas.add(PlataformaModel(id, plataforma.nomePlataforma))
    }

    fun updatePlataforma(id: String, @RequestBody plataforma: PutPlataformaRequest) {
        plataformas.filter { it.id == id }.first().let {
            it.nomePlataforma
        }
    }

    fun deletePlataforma(id: String) {
        plataformas.removeIf { it.id == id }
    }
}