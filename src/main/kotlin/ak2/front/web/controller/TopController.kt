package ak2.front.web.controller

import ak2.front.domain.repositories.AkUserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ak2/top")
class TopController(
  val akUserRepository: AkUserRepository
) {

  @GetMapping
  fun getTop(): String {
    return "/top/ak-top"
  }
}