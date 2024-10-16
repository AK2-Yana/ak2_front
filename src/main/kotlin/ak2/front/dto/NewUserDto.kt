package ak2.front.dto

import ak2.front.common.PasswordConverter.convertToBcrypt
import java.io.Serializable

data class NewUserDto(
  val userId: String,
  var password: String
) : Serializable {
  constructor(allRequestParam: Map<String, String>) : this(
    userId = allRequestParam.getOrDefault("userId", ""),
    password = allRequestParam.getOrDefault("password", "")
  )

  companion object {
    private const val strength = 16
    fun NewUserDto.passwordConverter() {
      this.apply {
        password = this.password.convertToBcrypt(16)
      }
    }
  }
}
