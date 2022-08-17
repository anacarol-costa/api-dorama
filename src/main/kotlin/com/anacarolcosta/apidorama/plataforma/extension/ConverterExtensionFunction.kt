package com.anacarolcosta.apidorama.plataforma.extension

import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel

fun PostPlataformaRequest.toPlataformaModel(): PlataformaModel {
    return PlataformaModel(nomePlataforma = this.nomePlataforma)
}

fun PutPlataformaRequest.toPlataformaModel(id: Int): PlataformaModel {
    return PlataformaModel(id = id, nomePlataforma = this.nomePlataforma)
}