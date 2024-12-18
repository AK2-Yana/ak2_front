package ak2.front.domain.repositories

import ak2.front.domain.entity.AkUser
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AkUserRepository : JpaRepository<AkUser, String> {

  @EntityGraph(attributePaths = ["roles"])
  override fun findById(id: String): Optional<AkUser>

  @Query(
    """
      select * 
      from users
      where user_id = :id
    """, nativeQuery = true
  )
  fun selectUserInfoById(@Param("id") id: String): AkUser?
}