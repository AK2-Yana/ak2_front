package ak2.front.domain.service

import ak2.front.domain.repositories.AkUserRepository
import org.springframework.stereotype.Service

@Service
class Ak2UserService(
  val akUserRepository: AkUserRepository
) {

  fun hasUserInfo(id: String): Boolean {
    return akUserRepository.selectUserInfoById(id) != null
  }
}