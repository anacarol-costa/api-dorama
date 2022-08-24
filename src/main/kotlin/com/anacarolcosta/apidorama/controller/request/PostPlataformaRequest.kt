package com.anacarolcosta.apidorama.controller.request

import com.anacarolcosta.apidorama.validation.PlataformaAvailable
import javax.validation.constraints.NotEmpty

data class PostPlataformaRequest (

    @field:NotEmpty(message = "O nome da plataforma deve ser informado!")
    @PlataformaAvailable
    var nomePlataforma: String
)