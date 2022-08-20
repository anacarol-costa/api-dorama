package com.anacarolcosta.apidorama.drama.controller.response

import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel

data class DramaResponse (
    var id: Int? = null,

    var titulo: String,

    var anoLancamento: String,

    var temporadas: Int,

    var quantidadeEpisodios: Int,

    var genero: GeneroModel? = null,

    var plataforma: PlataformaModel? = null
)