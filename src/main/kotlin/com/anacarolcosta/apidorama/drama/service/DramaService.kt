package com.anacarolcosta.apidorama.drama.service

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class DramaService {

    val dramas = mutableListOf<DramaModel>()

    fun getAllDrama(@RequestParam titulo: String?): List<DramaModel> {
        titulo?.let {
            return dramas.filter { it.titulo.contains(titulo, ignoreCase = true) }
        }
        return dramas
    }

    fun getByIdDrama(@PathVariable id: Int): DramaModel {
        return dramas.filter { it.id == id }.first()
    }

    fun createDrama(@RequestBody drama: PostDramaRequest) {
        val id = if (dramas.isEmpty()) {
            1
        } else {
            dramas.last().id!! + 1
        }

        dramas.add(DramaModel(id, drama.titulo, drama.anoLancamento, drama.temporadas, drama.quantidadeEpisodios, drama.genero, drama.plataforma))
    }

    fun updateDrama(@PathVariable id: Int, @RequestBody drama: PutDramaRequest) {
        dramas.filter { it.id == id }.first().let {
            it.titulo = drama.titulo
            it.anoLancamento = drama.anoLancamento
            it.temporadas = drama.temporadas
            it.quantidadeEpisodios = drama.quantidadeEpisodios
            it.genero= drama.genero
            it.plataforma = drama.plataforma

        }
    }

    fun deleteDrama(@PathVariable id: Int) {
        dramas.removeIf { it.id == id }
    }
}