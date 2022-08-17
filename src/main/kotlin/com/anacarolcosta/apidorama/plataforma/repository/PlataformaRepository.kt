package com.anacarolcosta.apidorama.plataforma.repository

import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel
import org.springframework.data.repository.CrudRepository

interface PlataformaRepository: CrudRepository<PlataformaModel, Int> {

    fun findByNameContaining(nomePlataforma: String): List<PlataformaModel>
}