package dependencyInteversion.correction

interface AuthService {
    fun login()
}

// low level module

class  FirebaseAuthService: AuthService {
    override fun login() {
        TODO("Not yet implemented")
    }

}
class GoogleAuthService: AuthService {
    override fun login() {
        TODO("Not yet implemented")
    }

}

// high level module

class LoginManager (private val authService: AuthService) {
    fun doLogin() {
        authService.login()
    }
}

//uses

fun main() {
    val firebase = FirebaseAuthService()
    val google = GoogleAuthService()

    val manager1 = LoginManager(firebase)
    manager1.doLogin()  // Firebase login

    val manager2 = LoginManager(google)
    manager2.doLogin()  // Google login
}
