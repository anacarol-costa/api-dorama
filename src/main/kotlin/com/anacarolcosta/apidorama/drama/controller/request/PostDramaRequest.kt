package com.anacarolcosta.apidorama.drama.controller.request

import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel

data class PostDramaRequest (
    var titulo: String,
    var anoLancamento: Int,
    var temporadas: Int,
    var quantidadeEpisodios: Int,
    var genero: GeneroModel,
    var plataforma: PlataformaModel
)