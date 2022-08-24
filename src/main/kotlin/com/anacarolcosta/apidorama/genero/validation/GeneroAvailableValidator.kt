package com.anacarolcosta.apidorama.genero.validation

import com.anacarolcosta.apidorama.genero.service.GeneroService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class GeneroAvailableValidator(var generoService: GeneroService): ConstraintValidator< GeneroAvailable, String> {

    override fun isValid(tipoGenero: String?, context: ConstraintValidatorContext?): Boolean {
        if (tipoGenero.isNullOrEmpty()){
            return false
        }
        return generoService.generoAvaible(tipoGenero)
    }
}