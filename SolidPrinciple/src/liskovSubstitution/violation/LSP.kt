package liskovSubstitution.violation

open class Bird() {
    open fun eat()= print("eat")
}

open class FlyingBird: Bird() {
    open fun fly() = print("fly")
}
class Eagle: FlyingBird() {
    override fun fly() {
        super.fly()
    }
}
class Ostrich: Bird() {
    override fun eat() {
        super.eat()
    }
}
// example
// //Agar koi class Bird hai, toh uske child (Eagle, Ostrich, etc.) ko use karne par bhi system ko theek-thaak kaam karna chahiye – bina kisi surprise ke."
//idhar dekh violation h rule ostrich udd nhi skta

// correct and defination :
//Derived classes must be substitutable for their base class without breaking the behavior.”

// use case violation
//open class BaseActivity {
//    open fun setupToolbar() {
//        println("Setting up toolbar")
//    }
//}
//
//class NoToolbarActivity : BaseActivity() {
//    override fun setupToolbar() {
//        throw IllegalStateException("No toolbar in this activity")
//    }
//}

//fix
open class BaseActivity {
    fun logLifecycle() = println("Logging lifecycle...")
}

abstract class ToolbarActivity : BaseActivity() {
    abstract fun setupToolbar()
}

class MainActivity : ToolbarActivity() {
    override fun setupToolbar() {
        println("Toolbar set with back button")
    }
}

class NoToolbarActivity : BaseActivity() {
    fun showMessage() = println("Welcome to full screen!")
}
