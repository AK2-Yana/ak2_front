package ak2.front.domain.entity

import ak2.front.domain.constraint.UserConstants.ACTIVE_USER
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "users")
data class AkUser(

  @Id
  val userId: String = "",

  val password: String = "",

  val enabled: String = ACTIVE_USER,

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "user_roles",
    joinColumns = [JoinColumn(name = "user_id")],
    inverseJoinColumns = [JoinColumn(name = "role_id")]
  )
  val roles: Set<UserAuthority> = emptySet()
) : Serializable
