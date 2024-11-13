package ak2.front.common

import org.springframework.stereotype.Component

@Component
class Ak2Helper : CommonPageHelper() {

  fun redirectToTopPage(): String {
    return super.redirectToSecurePageWithSeeOther("/ak2/top")
  }

  fun redirectToLoginPage(): String {
    return super.redirectToSecurePageWithSeeOther("/login")
  }

  fun redirectToNewUser(): String {
    return super.redirectToSecurePageWithSeeOther("/login/new")
  }
}