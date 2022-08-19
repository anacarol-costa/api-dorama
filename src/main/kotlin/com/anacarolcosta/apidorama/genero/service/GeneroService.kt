package com.anacarolcosta.apidorama.genero.service

import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class GeneroService {

    val generos = mutableListOf<GeneroModel>()

    fun getAllGenero(@RequestParam tipoGenero: String?): List<GeneroModel> {
        tipoGenero?.let {
            return generos.filter { it.tipoGenero.contains(tipoGenero, ignoreCase = true) }
        }
        return generos
    }

    fun getByIdGenero(@PathVariable id: Int): GeneroModel {
        return generos.filter { it.id == id }.first()
    }

    fun createGenero(@RequestBody genero: PostGeneroRequest) {
        val id = if (generos.isEmpty()) {
            1
        } else {
            generos.last().id!! + 1
        }

        generos.add(GeneroModel(id, genero.tipoGenero))
    }

    fun updateGenero(@PathVariable id: Int, @RequestBody genero: PutGeneroRequest) {
        generos.filter { it.id == id }.first().let {
            it.tipoGenero = genero.tipoGenero
        }
    }

    fun deleteGenero(@PathVariable id: Int) {
        generos.removeIf { it.id == id }
    }
}