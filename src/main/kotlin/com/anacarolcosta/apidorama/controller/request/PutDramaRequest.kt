package com.anacarolcosta.apidorama.controller.request

import com.anacarolcosta.apidorama.model.DramaModel
import com.anacarolcosta.apidorama.model.GeneroModel
import com.anacarolcosta.apidorama.model.PlataformaModel
import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PutDramaRequest (

    @field:NotEmpty(message = "Título deve ser informado")
    var titulo: String,

    @field:NotNull(message = "Ano de lançamento deve ser informado")
    var anoLancamento: Int,

    @field:NotNull(message = "Quantidade de temporadas deve ser informada")
    var temporadas: Int,

    @field:NotNull(message = "Quantidade de episódios deve ser informado")
    var quantidadeEpisodios: Int,

    @JsonAlias("genero_id")
    var generoId: Int,

    @JsonAlias("plataforma_id")
    var plataformaId: Int
) {

    fun toDramaModel(genero: GeneroModel, plataforma: PlataformaModel): DramaModel {
        return DramaModel(null,
            titulo,
            anoLancamento,
            temporadas,
            quantidadeEpisodios,
            genero,
            plataforma
        )
    }

}
