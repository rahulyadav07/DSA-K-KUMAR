/**
 * Vehicle interface following Interface Segregation Principle (ISP)
 * This interface defines the contract that all vehicles must implement
 * 
 * SOLID Principles Applied:
 * - Interface Segregation: Only essential methods for all vehicles
 * - Dependency Inversion: High-level modules depend on abstractions
 */
interface Vehicle {
    fun start()
    fun stop()
    fun getVehicleType(): String
    fun getMaxSpeed(): Int
    fun getFuelType(): String
}

/**
 * Vehicle properties data class for better encapsulation
 * Following Single Responsibility Principle (SRP)
 */
data class VehicleProperties(
    val type: String,
    val maxSpeed: Int,
    val fuelType: String,
    val seatingCapacity: Int,
    val weight: Double,
    val color: String = "White"
)

/**
 * Vehicle validation interface following Interface Segregation Principle
 */
interface VehicleValidator {
    fun validate(properties: VehicleProperties): Boolean
}

/**
 * Default vehicle validator implementation
 */
class DefaultVehicleValidator : VehicleValidator {
    override fun validate(properties: VehicleProperties): Boolean {
        return properties.maxSpeed > 0 && 
               properties.seatingCapacity > 0 && 
               properties.weight > 0.0 &&
               properties.type.isNotBlank() &&
               properties.fuelType.isNotBlank()
    }
}