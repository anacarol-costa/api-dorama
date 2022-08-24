package com.anacarolcosta.apidorama.service

import com.anacarolcosta.apidorama.model.DramaModel
import com.anacarolcosta.apidorama.repository.DramaRepository
import com.anacarolcosta.apidorama.enums.Errors
import com.anacarolcosta.apidorama.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class DramaService(
    private val dramaRepository: DramaRepository
) {

    fun getAllDrama(titulo: String?): List<DramaModel> {
        titulo?.let {
            return dramaRepository.findByTituloContaining(it)
        }
        return dramaRepository.findAll().toList()
    }

    fun getByIdDrama(id: Int): DramaModel {
        return dramaRepository.findById(id).orElseThrow(){ NotFoundException( Errors.ML2001.message.format(id), Errors.ML2001.code) }
    }

    fun createDrama(drama: DramaModel) {
        dramaRepository.save(drama)
    }

    fun findById(id: Int): DramaModel {
        return dramaRepository.findById(id).orElseThrow()
    }

    fun updateDrama(drama: DramaModel) {
//        if (!dramaRepository.existsById(drama.id!!)){
//            throw Exception()
//        }
       dramaRepository.save(drama)
    }

    fun deleteDrama(id: Int) {
        if (!dramaRepository.existsById(id)){
            throw Exception()
        }
        dramaRepository.deleteById(id)
    }

    fun dramaAvailable(titulo: String): Boolean {
        return !dramaRepository.existsByTitulo(titulo)
    }
}