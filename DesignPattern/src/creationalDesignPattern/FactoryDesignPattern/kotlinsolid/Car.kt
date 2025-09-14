package creationalDesignPattern.FactoryDesignPattern.kotlinsolid

import VehicleProperties

/**
 * Car implementation following Single Responsibility Principle (SRP)
 * This class is responsible only for car-specific behavior
 *
 * SOLID Principles Applied:
 * - Single Responsibility: Only handles car-specific operations
 * - Open/Closed: Open for extension, closed for modification
 * - Liskov Substitution: Can be substituted for Vehicle interface
 */
class Car(
    private val properties: VehicleProperties = VehicleProperties(
        type = "Car",
        maxSpeed = 200,
        fuelType = "Gasoline",
        seatingCapacity = 5,
        weight = 1500.0,
        color = "Blue"
    )
) : Vehicle {

    override fun start() {
        println("🚗 Car engine started with ${properties.fuelType} fuel")
        println("   Max Speed: ${properties.maxSpeed} km/h")
        println("   Seating Capacity: ${properties.seatingCapacity} passengers")
    }

    override fun stop() {
        println("🚗 Car engine stopped")
    }

    override fun getVehicleType(): String = properties.type

    override fun getMaxSpeed(): Int = properties.maxSpeed

    override fun getFuelType(): String = properties.fuelType

    fun getSeatingCapacity(): Int = properties.seatingCapacity

    fun getWeight(): Double = properties.weight

    fun getColor(): String = properties.color

    // Car-specific methods
    fun openTrunk() {
        println("🚗 Car trunk opened")
    }

    fun closeTrunk() {
        println("🚗 Car trunk closed")
    }

    override fun toString(): String {
        return "Car(type=${properties.type}, maxSpeed=${properties.maxSpeed}, " +
                "fuelType=${properties.fuelType}, seatingCapacity=${properties.seatingCapacity}, " +
                "weight=${properties.weight}kg, color=${properties.color})"
    }
}