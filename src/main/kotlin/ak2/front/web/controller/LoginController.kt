package ak2.front.web.controller

import ak2.front.common.Ak2Helper
import ak2.front.common.Ak2ModelAndView
import ak2.front.domain.service.Ak2UserService
import ak2.front.service.NewUserService
import ak2.front.web.dto.UserForm
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/login")
class LoginController(
  val ak2Helper: Ak2Helper,
  val ak2UserService: Ak2UserService,
  val newUserService: NewUserService
) {
  @GetMapping
  fun login(): Ak2ModelAndView {
    return Ak2ModelAndView("/common/login")
  }

  @GetMapping("/new")
  fun index(
    httpSession: HttpSession
  ): Ak2ModelAndView {
    return Ak2ModelAndView("/common/new-user")
  }

  @PostMapping("/new")
  fun create(
    @Validated @ModelAttribute userForm: UserForm,
    bindingResult: BindingResult
  ): String {
    if (bindingResult.hasErrors()) return ak2Helper.redirectToNewUser()

    if (ak2UserService.hasUserInfo(userForm.username)) throw IllegalAccessException()

    val akUser = newUserService.mapToAkUser(userForm)
    newUserService.registerUser(akUser)
    return ak2Helper.redirectToLoginPage()
  }
}