package ak2.front.repositories

import ak2.front.entity.AkUser
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AkUserRepository : JpaRepository<AkUser, String> {

  @EntityGraph(attributePaths = ["roles"])
  override fun findById(id: String): Optional<AkUser>
}