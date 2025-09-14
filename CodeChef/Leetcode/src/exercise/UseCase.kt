package exercise

class UseCase :  ParentClass(), ExerciseInterface  {
    override fun substract() {

    }

    override fun print() {
        super.print()
        //print("kjdhfkj")
    }

    override fun sum(a: Int, b: Int) {
        super.sum(a, b)
        print("neha")
    }



}

fun main() {
    val useCase = UseCase()
    useCase.sum(1,2)
}
