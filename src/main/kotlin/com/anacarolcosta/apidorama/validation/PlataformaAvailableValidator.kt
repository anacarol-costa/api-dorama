package com.anacarolcosta.apidorama.validation

import com.anacarolcosta.apidorama.service.PlataformaService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PlataformaAvailableValidator(var plataformaService: PlataformaService): ConstraintValidator<PlataformaAvailable, String> {

    override fun isValid(nomePlataforma: String?, context: ConstraintValidatorContext?): Boolean {
        if (nomePlataforma.isNullOrEmpty()){
            return false
        }
        return plataformaService.plataformaAvailable(nomePlataforma)
    }
}