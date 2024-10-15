package ak2.front.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "users")
data class AkUser(

  @Id
  val userId: String = "",

  val password: String = "",

  val enabled: String = "Y",

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "user_roles",
    joinColumns = [JoinColumn(name = "user_id")],
    inverseJoinColumns = [JoinColumn(name = "role_id")]
  )
  val roles: Set<UserAuthority> = emptySet()
) : Serializable
