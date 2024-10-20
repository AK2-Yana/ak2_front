package ak2.front.web.controller

import ak2.front.domain.repositories.AkUserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ak2/top")
class TopController(
  val akUserRepository: AkUserRepository
) {

  val log: Logger = LoggerFactory.getLogger(javaClass)

  @GetMapping
  fun getTop(): String {
    return "/top/ak-top"
  }
}