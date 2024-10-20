package ak2.front.web.controller

import ak2.front.common.Ak2Helper
import ak2.front.common.Ak2ModelAndView
import ak2.front.service.Ak2UserService
import ak2.front.web.dto.UserForm
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/login")
class LoginController(
  val ak2Helper: Ak2Helper,
  val ak2UserService: Ak2UserService
) {

  val log: Logger = LoggerFactory.getLogger(LoginController::class.java)

  @GetMapping
  fun login(): Ak2ModelAndView {
    return Ak2ModelAndView("/common/login")
  }

  @GetMapping("/new")
  fun index(): Ak2ModelAndView {
    return Ak2ModelAndView("/common/new-user")
  }

  @PostMapping("/new")
  fun create(
    @ModelAttribute userForm: UserForm
  ): String {
    if (ak2UserService.hasUserInfo(userForm.username)) {
      throw IllegalAccessException()
    }

    return ak2Helper.redirectToLoginPage()
  }
}