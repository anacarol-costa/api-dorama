package com.anacarolcosta.apidorama.controller.request

import javax.validation.constraints.NotEmpty

data class PutPlataformaRequest (

    @field:NotEmpty(message = "Nome da plataforma deve ser informada")
    var nomePlataforma: String
)