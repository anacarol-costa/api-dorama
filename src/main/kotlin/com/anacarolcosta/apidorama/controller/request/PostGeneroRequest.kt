package com.anacarolcosta.apidorama.controller.request

import com.anacarolcosta.apidorama.validation.GeneroAvailable
import javax.validation.constraints.NotEmpty

data class PostGeneroRequest (

    @field:NotEmpty(message = "O tipo de gênero deve ser informado!")
    @GeneroAvailable
    var tipoGenero: String
)