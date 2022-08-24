package com.anacarolcosta.apidorama.drama.repository

import com.anacarolcosta.apidorama.drama.model.DramaModel
import org.springframework.data.repository.CrudRepository

interface DramaRepository: CrudRepository<DramaModel, Int> {

    fun findByTituloContaining(titulo: String): List<DramaModel>

    fun existsByTitulo(titulo: String): Boolean
}