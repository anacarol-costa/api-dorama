package com.anacarolcosta.apidorama.plataforma.repository

import com.anacarolcosta.apidorama.plataforma.model.DramaModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlataformaRepository: CrudRepository<DramaModel, Int> {

    fun findByNomePlataformaContaining(nomePlataforma: String): List<DramaModel>
}