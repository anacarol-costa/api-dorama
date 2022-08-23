package com.anacarolcosta.apidorama.plataforma.controller.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PostPlataformaRequest (

    @field:NotEmpty(message = "O nome da plataforma deve ser informado!")
    var nomePlataforma: String
)