package ak2.front.common

private const val domain = "http://localhost:8085"

abstract class CommonPageHelper {

  fun redirectToSecurePageWithSeeOther(path: String): String {
    return "redirect:${domain}${path}"
  }
}