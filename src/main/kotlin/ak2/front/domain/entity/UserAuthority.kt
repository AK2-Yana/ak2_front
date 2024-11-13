package ak2.front.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "authorities")
data class UserAuthority(
  @Id
  val id: Int = 2,

  val name: String = "BASIC"
) : Serializable
