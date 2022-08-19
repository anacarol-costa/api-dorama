package com.anacarolcosta.apidorama.genero.repository

import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import org.springframework.data.repository.CrudRepository

interface GeneroRepository: CrudRepository<GeneroModel, Int> {
    fun findByTipoGeneroContaining(tipoGenero: String): List<GeneroModel>
}