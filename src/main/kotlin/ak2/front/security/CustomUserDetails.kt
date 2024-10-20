package ak2.front.security

import ak2.front.domain.entity.AkUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
  private val user: AkUser
) : UserDetails {

  override fun getAuthorities(): Collection<GrantedAuthority> {
    // ユーザーの権限を返す
    return user.roles.map { role -> SimpleGrantedAuthority(role.name) }
  }

  override fun getPassword(): String {
    // ユーザーのパスワードを返す
    return user.password
  }

  override fun getUsername(): String {
    // ユーザー名を返す
    return user.userId
  }

  override fun isAccountNonExpired(): Boolean {
    return true // アカウントの有効期限を定義する
  }

  override fun isAccountNonLocked(): Boolean {
    return true // アカウントのロック状態を定義する
  }

  override fun isCredentialsNonExpired(): Boolean {
    return true // 資格情報（パスワード）の有効期限を定義する
  }

  // ユーザーが有効かどうかを定義する
  override fun isEnabled(): Boolean {
    return user.enabled == "Y"
  }
}