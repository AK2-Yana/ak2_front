package ak2.front.common

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object PasswordConverter {
  fun String.convertToBcrypt(strength: Int): String = BCryptPasswordEncoder(strength).encode(this)
}