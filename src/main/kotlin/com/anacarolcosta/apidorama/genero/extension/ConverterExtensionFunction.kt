package com.anacarolcosta.apidorama.genero.extension

import com.anacarolcosta.apidorama.genero.controller.request.PostGeneroRequest
import com.anacarolcosta.apidorama.genero.controller.request.PutGeneroRequest
import com.anacarolcosta.apidorama.genero.model.GeneroModel

fun PostGeneroRequest.toGeneroModel(): GeneroModel {
    return GeneroModel(tipoGenero = this.tipoGenero)
}

fun PutGeneroRequest.toGeneroModel(id: Int): GeneroModel {
    return GeneroModel(id = id, tipoGenero = this.tipoGenero)
}