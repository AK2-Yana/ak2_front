package ak2.front.common

import org.springframework.stereotype.Component

@Component
class Ak2Helper : CommonPageHelper() {

  fun redirectToTopPage(): Ak2ModelAndView {
    return super.redirectTOSecurePageWithSeeOther("/ak2/top")
  }
}