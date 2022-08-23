package com.anacarolcosta.apidorama.plataforma.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [PlataformaAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PlataformaAvailable(
    val message: String = "Plataforma já cadastrada",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
