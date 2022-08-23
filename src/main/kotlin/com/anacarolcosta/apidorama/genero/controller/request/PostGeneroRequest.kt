package com.anacarolcosta.apidorama.genero.controller.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class PostGeneroRequest (

    @field:NotEmpty(message = "O tipo de gênero deve ser informado!")
    var tipoGenero: String
)