package singleresponsibilty

/**
 * this class be responsible for only managing the user .
 * also you can create  function for only one stakeholder .
 */
class UserManager(private val userRepo: UserRepo) {
    fun saveUser( user: User) {
       userRepo.save(user)
    }
    fun deleteUser(user: User) {
        userRepo.deleteUser(user)
    }
}

