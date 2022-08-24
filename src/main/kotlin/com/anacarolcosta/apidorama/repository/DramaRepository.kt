package com.anacarolcosta.apidorama.repository

import com.anacarolcosta.apidorama.model.DramaModel
import org.springframework.data.repository.CrudRepository

interface DramaRepository: CrudRepository<DramaModel, Int> {

    fun findByTituloContaining(titulo: String): List<DramaModel>

    fun existsByTitulo(titulo: String): Boolean
}