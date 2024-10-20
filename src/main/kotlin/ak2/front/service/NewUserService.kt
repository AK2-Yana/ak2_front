package ak2.front.service

import ak2.front.domain.service.Ak2UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class NewUserService(
  val passwordEncoder: PasswordEncoder,
  val ak2UserService: Ak2UserService
) {

  fun registerUser() {

  }

  companion object {
    fun String.encoder(service: NewUserService): String {
      return service.passwordEncoder.encode(this)
    }
  }
}