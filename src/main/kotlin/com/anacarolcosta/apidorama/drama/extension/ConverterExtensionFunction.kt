package com.anacarolcosta.apidorama.drama.extension

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel

fun PostDramaRequest.toDramaModel(): DramaModel {
    return DramaModel(titulo = this.titulo, anoLancamento = this.anoLancamento, temporadas = this.temporadas, quantidadeEpisodios = this.quantidadeEpisodios, genero = this.genero, plataforma = this.plataforma)
}

fun PutDramaRequest.toDramaModel(id: Int): DramaModel {
    return DramaModel(id = id, titulo = this.titulo, anoLancamento = this.anoLancamento, temporadas = this.temporadas, quantidadeEpisodios = this.quantidadeEpisodios, genero = this.genero, plataforma = this.plataforma)
}