/**
 * Truck implementation following Single Responsibility Principle (SRP)
 * This class is responsible only for truck-specific behavior
 * 
 * SOLID Principles Applied:
 * - Single Responsibility: Only handles truck-specific operations
 * - Open/Closed: Open for extension, closed for modification
 * - Liskov Substitution: Can be substituted for Vehicle interface
 */
class Truck(
    private val properties: VehicleProperties = VehicleProperties(
        type = "Truck",
        maxSpeed = 100,
        fuelType = "Diesel",
        seatingCapacity = 3,
        weight = 8000.0,
        color = "Yellow"
    )
) : Vehicle {
    
    override fun start() {
        println("🚛 Truck engine started with ${properties.fuelType} fuel")
        println("   Max Speed: ${properties.maxSpeed} km/h")
        println("   Seating Capacity: ${properties.seatingCapacity} passengers")
    }
    
    override fun stop() {
        println("🚛 Truck engine stopped")
    }
    
    override fun getVehicleType(): String = properties.type
    
    override fun getMaxSpeed(): Int = properties.maxSpeed
    
    override fun getFuelType(): String = properties.fuelType
    
    fun getSeatingCapacity(): Int = properties.seatingCapacity
    
    fun getWeight(): Double = properties.weight
    
    fun getColor(): String = properties.color
    
    // Truck-specific methods
    fun loadCargo(weight: Double) {
        println("🚛 Loading cargo: ${weight}kg")
    }
    
    fun unloadCargo() {
        println("🚛 Unloading cargo")
    }
    
    fun honk() {
        println("🚛 HONK! HONK! (Truck horn)")
    }
    
    override fun toString(): String {
        return "Truck(type=${properties.type}, maxSpeed=${properties.maxSpeed}, " +
                "fuelType=${properties.fuelType}, seatingCapacity=${properties.seatingCapacity}, " +
                "weight=${properties.weight}kg, color=${properties.color})"
    }
}
