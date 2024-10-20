package ak2.front.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
  val customUserDetailsService: CustomUserDetailsService
) {

  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http.authorizeHttpRequests {
      it.requestMatchers("/login/**").permitAll()
        .anyRequest().authenticated()
    }.formLogin { form ->
      form
        .loginPage("/login")
        .defaultSuccessUrl("/ak2/top", true)
        .permitAll()
    }.userDetailsService(customUserDetailsService)
    return http.build()
  }

  @Bean
  fun authenticationManager(
    userDetailsService: CustomUserDetailsService,
    passwordEncoder: PasswordEncoder
  ): AuthenticationManager {
    val authenticationProvider = DaoAuthenticationProvider()
    authenticationProvider.setUserDetailsService(userDetailsService)
    authenticationProvider.setPasswordEncoder(passwordEncoder)

    val providerManager = ProviderManager(authenticationProvider)

    // To retain user information without copy of object
    // TODO: I will try to modify this to other way
    providerManager.isEraseCredentialsAfterAuthentication = false

    return providerManager
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder(16)
  }
}