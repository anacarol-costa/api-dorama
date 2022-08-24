package com.anacarolcosta.apidorama.service

import com.anacarolcosta.apidorama.enums.Errors
import com.anacarolcosta.apidorama.exception.NotFoundException
import com.anacarolcosta.apidorama.model.GeneroModel
import com.anacarolcosta.apidorama.repository.GeneroRepository
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
        return generoRepository.findById(id).orElseThrow(){ NotFoundException( Errors.ML3001.message.format(id), Errors.ML3001.code) }
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

    fun generoAvaible(tipoGenero: String): Boolean {
        return !generoRepository.existsByTipoGenero(tipoGenero)
    }
}