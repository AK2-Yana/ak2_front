package ak2.front.domain.annotations

import ak2.front.domain.validator.CheckUserValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CheckUserValidator::class])
@MustBeDocumented
@Repeatable
annotation class CheckUsername(
  val message: String = "check user name",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = []
)