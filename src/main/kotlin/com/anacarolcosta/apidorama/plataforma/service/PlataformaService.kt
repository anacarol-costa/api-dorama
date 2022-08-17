package com.anacarolcosta.apidorama.plataforma.service

import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
import org.springframework.stereotype.Service

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

    fun createPlataforma(plataforma: PlataformaModel) {
        val id = if (plataformas.isEmpty()) {
            1
        } else {
            plataformas.last().id!!.toInt() +1
        }.toString()

        plataforma.id = id

        plataformas.add(plataforma)
    }

    fun updatePlataforma(plataforma: PlataformaModel) {
        plataformas.filter { it.id == plataforma.id }.first().let {
            it.nomePlataforma = plataforma.nomePlataforma
        }
    }

    fun deletePlataforma(id: String) {
        plataformas.removeIf { it.id == id }
    }
}