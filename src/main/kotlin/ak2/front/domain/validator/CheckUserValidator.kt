package ak2.front.domain.validator

import ak2.front.domain.annotations.CheckUsername
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CheckUserValidator : ConstraintValidator<CheckUsername, String> {

  companion object {
    private val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W)[\\S]+$")
  }

  override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
    if (value.isNullOrEmpty()) {
      overrideDefaultMessage("Please put username", context)
      return false
    } else if (value.length >= 10) {
      overrideDefaultMessage("have to be put more than or equal 10", context)
      return false
    } else if (!regex.matches(value)) {
      overrideDefaultMessage("you must use upper and lower case and special characters and digit at least one", context)
      return false
    }

    return true
  }

  private fun overrideDefaultMessage(message: String, context: ConstraintValidatorContext) {
    context.disableDefaultConstraintViolation()
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation()
  }
}