package models

import org.squeryl._
import org.squeryl.PrimitiveTypeMode._

case class User(
  username: String,
  password: String
)


object User {
  import Database.usersTable

  def create(username: String, password: String): User = inTransaction {
    usersTable.insert(User(username, password))
  }

  def all: Query[User] = from(usersTable) {
    user => select(user)
  }

  def findAll: Iterable[User] = inTransaction {
    all.toList
  }
  
}

object Database extends Schema {
  val usersTable: Table[User] = table[User]("users")

  Database.create
}

