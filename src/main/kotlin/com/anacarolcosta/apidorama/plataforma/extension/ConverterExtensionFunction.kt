package com.anacarolcosta.apidorama.plataforma.extension

import com.anacarolcosta.apidorama.plataforma.controller.request.PostPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.controller.request.PutPlataformaRequest
import com.anacarolcosta.apidorama.plataforma.model.PlataformaModel

fun PostPlataformaRequest.toPlataformaModel(): PlataformaModel {
    return PlataformaModel(id = null, nomePlataforma = this.nomePlataforma)
}

fun PutPlataformaRequest.toPlataformaModel(id: String): PlataformaModel {
    return PlataformaModel(id = id, nomePlataforma = this.nomePlataforma)
}