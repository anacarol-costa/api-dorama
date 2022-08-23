package com.anacarolcosta.apidorama.plataforma.controller.request

import com.anacarolcosta.apidorama.plataforma.validation.PlataformaAvailable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PostPlataformaRequest (

    @field:NotEmpty(message = "O nome da plataforma deve ser informado!")
    @PlataformaAvailable
    var nomePlataforma: String
)