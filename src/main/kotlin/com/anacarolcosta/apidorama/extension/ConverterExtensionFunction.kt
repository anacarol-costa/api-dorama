package com.anacarolcosta.apidorama.extension

import com.anacarolcosta.apidorama.drama.controller.request.PostDramaRequest
import com.anacarolcosta.apidorama.drama.controller.request.PutDramaRequest
import com.anacarolcosta.apidorama.drama.model.DramaModel
import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel

fun PostDramaRequest.toDramaModel(genero: GeneroModel, plataforma: PlataformaModel): DramaModel {
    return DramaModel(
        titulo = this.titulo,
        anoLancamento = this.anoLancamento,
        temporadas = this.temporadas,
        quantidadeEpisodios = this.quantidadeEpisodios,
        genero = genero,
        plataforma = plataforma)
}

fun PutDramaRequest.toDramaModel(previousValue: DramaModel): DramaModel {
    return DramaModel(
        id = previousValue.id,
        titulo = this.titulo,
        anoLancamento = this.anoLancamento,
        temporadas = this.temporadas,
        quantidadeEpisodios = this.quantidadeEpisodios,
        genero = previousValue.genero,
        plataforma = previousValue.plataforma)
}

fun PostGeneroRequest.toGeneroModel(): GeneroModel {
    return GeneroModel(tipoGenero = this.tipoGenero)
}

fun PutGeneroRequest.toGeneroModel(id: Int): GeneroModel {
    return GeneroModel(id = id, tipoGenero = this.tipoGenero)
}

fun PostPlataformaRequest.toPlataformaModel(): com.anacarolcosta.apidorama.plataforma.model.PlataformaModel {
    return com.anacarolcosta.apidorama.plataforma.model.PlataformaModel(nomePlataforma = this.nomePlataforma)
}

fun PutPlataformaRequest.toPlataformaModel(id: Int): com.anacarolcosta.apidorama.plataforma.model.PlataformaModel {
    return com.anacarolcosta.apidorama.plataforma.model.PlataformaModel(id = id, nomePlataforma = this.nomePlataforma)
}