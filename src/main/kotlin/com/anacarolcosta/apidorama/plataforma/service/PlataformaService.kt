package com.anacarolcosta.apidorama.plataforma.service

import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
import com.anacarolcosta.apidorama.plataforma.repository.PlataformaRepository
import org.springframework.stereotype.Service

@Service
class PlataformaService(
    private val plataformaRepository: PlataformaRepository
) {
    fun getAllPlataforma(nomePlataforma: String?): List<PlataformaModel>{
        nomePlataforma?.let {
            return plataformaRepository.findByNomePlataformaContaining(it)
        }
        return plataformaRepository.findAll().toList()
    }

    fun getByIdPlataforma(id: Int): PlataformaModel {
        return plataformaRepository.findById(id).orElseThrow{Exception("Esta plataforma não existe!")}
    }

    fun createPlataforma(plataforma: PlataformaModel) {
        plataformaRepository.save(plataforma)
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
}