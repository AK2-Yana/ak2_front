package ak2.front.service

import ak2.front.domain.constraint.UserConstants.ACTIVE_USER
import ak2.front.domain.entity.AkUser
import ak2.front.domain.repositories.AkUserRepository
import ak2.front.web.dto.UserForm
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class NewUserService(
  val passwordEncoder: PasswordEncoder,
  val akUserRepository: AkUserRepository
) {
  fun mapToAkUser(userForm: UserForm): AkUser {
    return AkUser(
      userId = userForm.username,
      password = userForm.password.encoder(),
      enabled = ACTIVE_USER
    )
  }

  fun registerUser(akUser: AkUser) {
    akUserRepository.save(akUser)
  }

  private fun String.encoder(): String {
    return passwordEncoder.encode(this)
  }
}