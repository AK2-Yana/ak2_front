package ak2.front.web.dto

import java.io.Serializable

data class UserForm(
  val username: String,
  var password: String
) : Serializable
