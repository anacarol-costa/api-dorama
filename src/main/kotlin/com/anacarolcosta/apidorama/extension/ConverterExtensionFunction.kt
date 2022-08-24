package com.anacarolcosta.apidorama.extension

import com.anacarolcosta.apidorama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.model.DramaModel
import com.anacarolcosta.apidorama.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.model.GeneroModel
import com.anacarolcosta.apidorama.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.controller.response.PlataformaResponse
import com.anacarolcosta.apidorama.model.PlataformaModel

fun PostDramaRequest.toDramaModel(genero: GeneroModel, plataforma: PlataformaModel): DramaModel {
    return DramaModel(
        titulo = this.titulo,
        anoLancamento = this.anoLancamento,
        temporadas = this.temporadas,
        quantidadeEpisodios = this.quantidadeEpisodios,
        genero = genero,
        plataforma = plataforma
    )
}

fun PutDramaRequest.toDramaModel(previousValue: DramaModel): DramaModel {
    return DramaModel(
        id = previousValue.id,
        titulo = this.titulo,
        anoLancamento = this.anoLancamento,
        temporadas = this.temporadas,
        quantidadeEpisodios = this.quantidadeEpisodios,
        genero = previousValue.genero,
        plataforma = previousValue.plataforma
    )
}

fun PostGeneroRequest.toGeneroModel(): GeneroModel {
    return GeneroModel(tipoGenero = this.tipoGenero)
}

fun PutGeneroRequest.toGeneroModel(id: Int): GeneroModel {
    return GeneroModel(id = id, tipoGenero = this.tipoGenero)
}

fun PostPlataformaRequest.toPlataformaModel(): PlataformaModel {
    return PlataformaModel(nomePlataforma = this.nomePlataforma)
}

fun PutPlataformaRequest.toPlataformaModel(id: Int): PlataformaModel {
    return PlataformaModel(id = id, nomePlataforma = this.nomePlataforma)
}

fun PlataformaModel.toResponse(): PlataformaResponse {
    return PlataformaResponse(
        id = this.id,
        nomePlataforma = this.nomePlataforma
    )
}