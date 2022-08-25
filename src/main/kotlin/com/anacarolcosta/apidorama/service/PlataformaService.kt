package com.anacarolcosta.apidorama.service

import com.anacarolcosta.apidorama.exception.NotFoundException
import com.anacarolcosta.apidorama.model.PlataformaModel
import com.anacarolcosta.apidorama.repository.PlataformaRepository
import org.springframework.stereotype.Service
import com.anacarolcosta.apidorama.enums.Errors

@Service
class PlataformaService(
    private val plataformaRepository: PlataformaRepository
) {
    fun getAllPlataforma(): List<PlataformaModel>{
        return plataformaRepository.findAll().toList()
    }

    fun getByIdPlataforma(id: Int): PlataformaModel {
        return plataformaRepository.findById(id).orElseThrow{ NotFoundException( Errors.ML1001.message.format(id), Errors.ML1001.code) }
    }

    fun createPlataforma(plataforma: PlataformaModel) {
        plataformaRepository.save(plataforma)
    }

    fun findById(id: Int): PlataformaModel {
        return plataformaRepository.findById(id).orElseThrow()
    }

    fun updatePlataforma(plataforma: PlataformaModel) {
       if (!plataformaRepository.existsById(plataforma.id!!)){
           throw Exception()
       }
        plataformaRepository.save(plataforma)
    }

    fun deletePlataforma(id: Int) {
        if (!plataformaRepository.existsById(id)){
            throw Exception()
        }
        plataformaRepository.deleteById(id)
    }

    fun plataformaAvailable(nomePlataforma: String): Boolean {
        return !plataformaRepository.existsByNomePlataforma(nomePlataforma)
    }
}