package ak2.front.common

private const val domain = "http://localhost:8085"

abstract class CommonPageHelper {

  fun redirectTOSecurePageWithSeeOther(path: String): Ak2ModelAndView {
    return Ak2ModelAndView("redirect:${domain}${path}")
  }
}