package com.anacarolcosta.apidorama.drama.controller.request

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
)
