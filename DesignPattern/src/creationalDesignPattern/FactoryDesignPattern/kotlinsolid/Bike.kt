package creationalDesignPattern.FactoryDesignPattern.kotlinsolid

import VehicleProperties

/**
 * Bike implementation following Single Responsibility Principle (SRP)
 * This class is responsible only for bike-specific behavior
 *
 * SOLID Principles Applied:
 * - Single Responsibility: Only handles bike-specific operations
 * - Open/Closed: Open for extension, closed for modification
 * - Liskov Substitution: Can be substituted for Vehicle interface
 */
class Bike(
    private val properties: VehicleProperties = VehicleProperties(
        type = "Bike",
        maxSpeed = 120,
        fuelType = "Gasoline",
        seatingCapacity = 2,
        weight = 200.0,
        color = "Red"
    )
) : Vehicle {

    override fun start() {
        println("🏍️ Bike engine started with ${properties.fuelType} fuel")
        println("   Max Speed: ${properties.maxSpeed} km/h")
        println("   Seating Capacity: ${properties.seatingCapacity} passengers")
    }

    override fun stop() {
        println("🏍️ Bike engine stopped")
    }

    override fun getVehicleType(): String = properties.type

    override fun getMaxSpeed(): Int = properties.maxSpeed

    override fun getFuelType(): String = properties.fuelType

    fun getSeatingCapacity(): Int = properties.seatingCapacity

    fun getWeight(): Double = properties.weight

    fun getColor(): String = properties.color

    // Bike-specific methods
    fun putOnHelmet() {
        println("🏍️ Helmet put on for safety")
    }

    fun takeOffHelmet() {
        println("🏍️ Helmet taken off")
    }

    fun wheelie() {
        println("🏍️ Performing a wheelie!")
    }

    override fun toString(): String {
        return "Bike(type=${properties.type}, maxSpeed=${properties.maxSpeed}, " +
                "fuelType=${properties.fuelType}, seatingCapacity=${properties.seatingCapacity}, " +
                "weight=${properties.weight}kg, color=${properties.color})"
    }
}