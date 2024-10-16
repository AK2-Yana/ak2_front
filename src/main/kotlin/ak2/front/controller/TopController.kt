package ak2.front.controller

import ak2.front.repositories.AkUserRepository
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
    log.info(akUserRepository.findAll().first().userId)
    return "/top/ak-top"
  }
}