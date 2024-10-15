package ak2.front.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "authorities")
data class UserAuthority(
  @Id
  val id: Int = 0,

  val name: String = "" // 例えば "ADMIN", "USER" などのロール名
) : Serializable
