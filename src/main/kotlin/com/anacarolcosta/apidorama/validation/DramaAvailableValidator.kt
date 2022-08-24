package com.anacarolcosta.apidorama.validation

import com.anacarolcosta.apidorama.service.DramaService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class DramaAvailableValidator(var dramaService: DramaService): ConstraintValidator<DramaAvailable, String> {

    override fun isValid(titulo: String?, context: ConstraintValidatorContext?): Boolean {
        if (titulo.isNullOrEmpty()){
            return false
        }
        return dramaService.dramaAvailable(titulo)
    }
}