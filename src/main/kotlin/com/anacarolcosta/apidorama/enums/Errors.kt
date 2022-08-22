package com.anacarolcosta.apidorama.enums

enum class Errors( val code: String, val message: String) {

    //Plataforma (1001 a 1999) | Drama (2001 a 2999) | Genero (3001 a 3999)

    ML1001(
        "ML-1001",
        "Plataforma [%s] não existe!"
    ),

    ML2001(
        "ML-2001",
        "Drama [%s] não existe!"
    ),

    ML3001(
        "ML-3001",
        "Genero [%s] não existe!"
    )
}