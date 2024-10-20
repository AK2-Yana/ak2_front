package ak2.front.service

import ak2.front.domain.repositories.AkUserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class Ak2UserService(
  val akUserRepository: AkUserRepository,
  val passwordEncoder: PasswordEncoder
) {

  fun hasUserInfo(id: String): Boolean {
    return akUserRepository.selectUserInfoById(id) != null
  }

  companion object {
    fun String.encoder(service: Ak2UserService): String {
      return service.passwordEncoder.encode(this)
    }
  }
}