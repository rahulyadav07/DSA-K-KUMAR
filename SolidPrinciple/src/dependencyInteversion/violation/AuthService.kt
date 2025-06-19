package dependencyInteversion.violation

//High-level module(bussiness logic) ko low-level module (implementation)pe depend nahi karna chahiye. Dono abstraction pe depend karein.
// Low-level module
class FirebaseAuthService {
    fun login() {
        println("Logged in with Firebase")
    }
}

// High-level module
class LoginManager {
    private val authService = FirebaseAuthService() // ❌ Tightly Coupled

    fun doLogin() {
        authService.login()
    }
}
// login manager directly depend h firebase auth service pr
// kal ko agr mujhe new service cahhiye to testing ke liye toh login mager ka code disturb krna padega