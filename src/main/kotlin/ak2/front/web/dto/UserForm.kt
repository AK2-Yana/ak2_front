package ak2.front.web.dto

import org.jetbrains.annotations.NotNull
import java.io.Serializable

data class UserForm(

  @NotNull
  val username: String,

  @NotNull
  var password: String
) : Serializable
