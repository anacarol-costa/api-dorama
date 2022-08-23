package com.anacarolcosta.apidorama.plataforma.repository

import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlataformaRepository: CrudRepository<PlataformaModel, Int> {

    fun findByNomePlataformaContaining(nomePlataforma: String): List<PlataformaModel>

    fun existsByNomePlataforma(nomePlataforma: String): Boolean
}