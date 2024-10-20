package ak2.front.security

import ak2.front.domain.entity.AkUser
import ak2.front.domain.repositories.AkUserRepository
import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomUserDetailsService(
  val akUserRepository: AkUserRepository
) : UserDetailsService {

  override fun loadUserByUsername(username: String): UserDetails {
    return getUserWithLazyLoading(username)?.let {
      CustomUserDetails(it)
    } ?: throw UsernameNotFoundException("")
  }

  @Transactional
  fun getUserWithLazyLoading(userId: String): AkUser? {
    val user = akUserRepository.findById(userId).toNullable() // ユーザーを取得
    // ここでロールはまだロードされていない（Lazy Loading）
    // その後、rolesプロパティにアクセスすることで初めてロードされる
    user?.roles?.forEach { role ->
      println(role) // ここでLazy Loadingがトリガーされる
    }
    return user
  }

  fun <T> Optional<T>.toNullable(): T? = this.orElse(null)
}