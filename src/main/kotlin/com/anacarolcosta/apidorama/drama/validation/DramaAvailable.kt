package com.anacarolcosta.apidorama.drama.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [DramaAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class DramaAvailable(
    val message: String = "Título já cadastrado",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
