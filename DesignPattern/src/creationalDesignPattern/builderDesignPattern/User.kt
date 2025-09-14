package creationalDesignPattern.builderDesignPattern


/*
Create an Interface, an Abstract Class, a Parent class with at least one method, Create a class
that should be able to override methods from these three entity. Use Kotlin code syntax for this activity
 */
class User private constructor(builder: Builder) {
    private val name: String?
    private val email: String?
    private val age: Int
    private val phoneNumber: String?

    init {
        this.age = builder.age
        this.email = builder.email
        this.name = builder.name
        this.phoneNumber = builder.phoneNumber
    }

    fun printAllField() {
        println(name)
        println(email)
        println(phoneNumber)
        println(age)
    }

    class Builder(private val name: String?) {
        private var email: String? = null
        private var age = 0
        private var phoneNumber: String? = null

        fun setEmail(email: String?): Builder {
            this.email = email
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun setPhoneNumber(phoneNumber: String?): Builder {
            this.phoneNumber = phoneNumber
            return this
        }

        fun build(): User {
            return User(this)
        }
    }
}

