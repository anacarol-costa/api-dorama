package com.anacarolcosta.apidorama.plataforma.service

import com.anacarolcosta.apidorama.exception.NotFoundException
import com.anacarolcosta.apidorama.plataforma.model.DramaModel
import com.anacarolcosta.apidorama.plataforma.repository.PlataformaRepository
import org.springframework.stereotype.Service
import com.anacarolcosta.apidorama.enums.Errors

@Service
class PlataformaService(
    private val plataformaRepository: PlataformaRepository
) {
    fun getAllPlataforma(nomePlataforma: String?): List<DramaModel>{
        nomePlataforma?.let {
            return plataformaRepository.findByNomePlataformaContaining(it)
        }
        return plataformaRepository.findAll().toList()
    }

    fun getByIdPlataforma(id: Int): DramaModel {
        return plataformaRepository.findById(id).orElseThrow{ NotFoundException( Errors.ML1001.message.format(id), Errors.ML1001.code) }
    }

    fun createPlataforma(plataforma: DramaModel) {
        plataformaRepository.save(plataforma)
    }

    fun updatePlataforma(plataforma: DramaModel) {
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
}