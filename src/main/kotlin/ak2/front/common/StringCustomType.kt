package ak2.front.common

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.usertype.UserType
import java.io.Serializable
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types

@Deprecated("This class does not use but let me retain this for study")
class StringCustomType : UserType<java.lang.String> {

  override fun equals(x: java.lang.String?, y: java.lang.String?): Boolean {
    return x == y
  }

  override fun hashCode(x: java.lang.String?): Int {
    return x.hashCode()
  }

  override fun getSqlType(): Int {
    return Types.VARCHAR
  }

  override fun returnedClass(): Class<java.lang.String> {
    return java.lang.String::class.java
  }

  override fun nullSafeGet(rs: ResultSet?, position: Int, session: SharedSessionContractImplementor?, owner: Any?): java.lang.String {
    return rs?.getString(position) as java.lang.String
  }

  override fun isMutable(): Boolean {
    return true
  }

  override fun assemble(cached: Serializable?, owner: Any?): java.lang.String {
    return cached.toString() as java.lang.String
  }

  override fun disassemble(value: java.lang.String?): Serializable {
    return value ?: "" as java.lang.String
  }

  override fun deepCopy(value: java.lang.String?): java.lang.String {
    return value ?: "" as java.lang.String
  }

  override fun nullSafeSet(st: PreparedStatement?, value: java.lang.String?, index: Int, session: SharedSessionContractImplementor?) {
    st!!.setString(index, value.toString())
  }

}