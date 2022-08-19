package com.anacarolcosta.apidorama.plataforma.extension

import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.DramaModel

fun PostPlataformaRequest.toPlataformaModel(): DramaModel {
    return DramaModel(nomePlataforma = this.nomePlataforma)
}

fun PutPlataformaRequest.toPlataformaModel(id: Int): DramaModel {
    return DramaModel(id = id, nomePlataforma = this.nomePlataforma)
}