package ak2.front.controller

import ak2.front.common.Ak2Helper
import ak2.front.common.Ak2ModelAndView
import ak2.front.dto.NewUserDto
import ak2.front.dto.NewUserDto.Companion.passwordConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/login")
class LoginController(
  val ak2Helper: Ak2Helper
) {

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
    @RequestParam allRequestParam: Map<String, String>
  ): Ak2ModelAndView {
    val data = NewUserDto(allRequestParam).passwordConverter()

    return ak2Helper.redirectToTopPage()
  }
}