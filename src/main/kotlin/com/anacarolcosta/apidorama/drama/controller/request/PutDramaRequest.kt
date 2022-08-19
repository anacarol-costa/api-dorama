package com.anacarolcosta.apidorama.drama.controller.request

import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.plataforma.model.DramaModel

data class PutDramaRequest (

    var titulo: String,
    var anoLancamento: Int,
    var temporadas: Int,
    var quantidadeEpisodios: Int,
    var genero: GeneroModel,
    var plataforma: DramaModel
)
