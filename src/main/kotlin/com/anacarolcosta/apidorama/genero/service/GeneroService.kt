package com.anacarolcosta.apidorama.genero.service

import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.genero.repository.GeneroRepository
import org.springframework.stereotype.Service

@Service
class GeneroService(
    private val generoRepository: GeneroRepository
) {
    fun getAllGenero(tipoGenero: String?): List<GeneroModel> {
        tipoGenero?.let {
            return generoRepository.findByTipoGeneroContaining(it)
        }
        return generoRepository.findAll().toList()
    }

    fun getByIdGenero(id: Int): GeneroModel {
        return generoRepository.findById(id).orElseThrow()
    }

    fun createGenero(genero: GeneroModel) {
        generoRepository.save(genero)
    }

    fun findById(id: Int): GeneroModel {
        return generoRepository.findById(id).orElseThrow()
    }

    fun updateGenero(genero: GeneroModel) {
       if (!generoRepository.existsById(genero.id!!)){
           throw Exception()
       }
        generoRepository.save(genero)
    }

    fun deleteGenero(id: Int) {
        if (!generoRepository.existsById(id!!)){
            throw Exception()
        }
        generoRepository.deleteById(id)
    }
}