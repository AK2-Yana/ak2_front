package ak2.front.common

import org.springframework.http.HttpStatus
import org.springframework.web.servlet.ModelAndView

class Ak2ModelAndView : ModelAndView {
  constructor(htmlPage: String) : super(htmlPage, HttpStatus.OK)
  constructor(htmlPage: String, model: Any?) : super(htmlPage, "page", model) {
    status = HttpStatus.OK
  }
}