package com.anacarolcosta.apidorama.drama.service

import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.drama.repository.DramaRepository
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
        return dramaRepository.findById(id).orElseThrow()
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
}