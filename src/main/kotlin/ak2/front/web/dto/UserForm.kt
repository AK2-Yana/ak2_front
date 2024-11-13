package ak2.front.web.dto

import ak2.front.domain.annotations.CheckUsername
import jakarta.validation.constraints.NotEmpty
import java.io.Serializable

data class UserForm(

  @CheckUsername
  val username: String,

  @NotEmpty
  var password: String
) : Serializable
