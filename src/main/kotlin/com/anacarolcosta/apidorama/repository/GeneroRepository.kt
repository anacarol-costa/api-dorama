package com.anacarolcosta.apidorama.repository

import com.anacarolcosta.apidorama.model.GeneroModel
import org.springframework.data.repository.CrudRepository

interface GeneroRepository: CrudRepository<GeneroModel, Int> {

    fun findByTipoGeneroContaining(tipoGenero: String): List<GeneroModel>

    fun existsByTipoGenero(tipoGenero: String): Boolean
}