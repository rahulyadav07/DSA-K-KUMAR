/**
 * Comprehensive demonstration of Factory Pattern with SOLID Principles
 * 
 * This demo shows how SOLID principles make the code:
 * - More maintainable
 * - More extensible
 * - More testable
 * - More flexible
 */
fun main() {
    println("=== Factory Pattern with SOLID Principles Demo ===\n")
    
    // Demonstrate basic factory usage
    demonstrateBasicFactory()
    
    println("\n${"=".repeat(60)}\n")
    
    // Demonstrate custom properties
    demonstrateCustomProperties()
    
    println("\n${"=".repeat(60)}\n")
    
    // Demonstrate electric vehicle factory (Open/Closed Principle)
    demonstrateElectricVehicleFactory()
    
    println("\n${"=".repeat(60)}\n")
    
    // Demonstrate error handling
    demonstrateErrorHandling()
    
    println("\n${"=".repeat(60)}\n")
    
    // Demonstrate factory with different validators (Dependency Inversion)
    demonstrateCustomValidator()
    
    println("\n=== Demo completed successfully! ===")
}

/**
 * Demonstrate basic factory usage following SOLID principles
 */
fun demonstrateBasicFactory() {
    println("1. Basic Factory Usage (Single Responsibility & Liskov Substitution)")
    
    val factory = ConcreteVehicleFactory()
    
    // Create different types of vehicles
    val vehicles = listOf(
        factory.createVehicle(VehicleType.CAR),
        factory.createVehicle(VehicleType.BIKE),
        factory.createVehicle(VehicleType.TRUCK)
    )
    
    println("Created vehicles:")
    vehicles.forEach { vehicle ->
        println("  - ${vehicle.getVehicleType()}: Max Speed ${vehicle.getMaxSpeed()} km/h, Fuel: ${vehicle.getFuelType()}")
    }
    
    println("\nTesting vehicle operations:")
    vehicles.forEach { vehicle ->
        vehicle.start()
        vehicle.stop()
        println()
    }
}

/**
 * Demonstrate custom properties (Open/Closed Principle)
 */
fun demonstrateCustomProperties() {
    println("2. Custom Properties (Open/Closed Principle)")
    
    val factory = ConcreteVehicleFactory()
    
    // Create vehicles with custom properties
    val customCar = factory.createVehicleWithProperties(
        VehicleType.CAR,
        VehicleProperties(
            type = "Sports creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car",
            maxSpeed = 300,
            fuelType = "Premium Gasoline",
            seatingCapacity = 2,
            weight = 1200.0,
            color = "Red"
        )
    )
    
    val customBike = factory.createVehicleWithProperties(
        VehicleType.BIKE,
        VehicleProperties(
            type = "Racing creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Bike",
            maxSpeed = 250,
            fuelType = "High-Octane Gasoline",
            seatingCapacity = 1,
            weight = 150.0,
            color = "Black"
        )
    )
    
    println("Custom vehicles created:")
    println("  - $customCar")
    println("  - $customBike")
    
    println("\nTesting custom vehicles:")
    customCar.start()
    customBike.start()
}

/**
 * Demonstrate electric vehicle factory (Open/Closed Principle)
 */
fun demonstrateElectricVehicleFactory() {
    println("3. Electric Vehicle Factory (Open/Closed Principle)")
    
    val electricFactory = ElectricVehicleFactory()
    
    println("Creating electric vehicles:")
    val electricVehicles = listOf(
        electricFactory.createVehicle(VehicleType.CAR),
        electricFactory.createVehicle(VehicleType.BIKE),
        electricFactory.createVehicle(VehicleType.TRUCK)
    )
    
    electricVehicles.forEach { vehicle ->
        println("  - ${vehicle.getVehicleType()}: Max Speed ${vehicle.getMaxSpeed()} km/h, Fuel: ${vehicle.getFuelType()}")
        vehicle.start()
        vehicle.stop()
        println()
    }
}

/**
 * Demonstrate error handling
 */
fun demonstrateErrorHandling() {
    println("4. Error Handling (Robust Design)")
    
    val factory = ConcreteVehicleFactory()
    
    try {
        // Try to create vehicle with invalid properties
        factory.createVehicleWithProperties(
            VehicleType.CAR,
            VehicleProperties(
                type = "",
                maxSpeed = -100, // Invalid negative speed
                fuelType = "",
                seatingCapacity = 0, // Invalid capacity
                weight = -500.0, // Invalid negative weight
                color = "Blue"
            )
        )
    } catch (e: VehicleCreationException) {
        println("❌ Error caught: ${e.message}")
    }
    
    println("✅ Error handling works correctly!")
}

/**
 * Demonstrate custom validator (Dependency Inversion Principle)
 */
fun demonstrateCustomValidator() {
    println("5. Custom Validator (Dependency Inversion Principle)")
    
    // Custom validator that allows only high-performance vehicles
    val highPerformanceValidator = object : VehicleValidator {
        override fun validate(properties: VehicleProperties): Boolean {
            return properties.maxSpeed >= 200 && 
                   properties.weight <= 2000.0 &&
                   properties.type.isNotBlank() &&
                   properties.fuelType.isNotBlank()
        }
    }
    
    val highPerformanceFactory = ConcreteVehicleFactory(highPerformanceValidator)
    
    try {
        // This should work - high performance car
        val sportsCar = highPerformanceFactory.createVehicleWithProperties(
            VehicleType.CAR,
            VehicleProperties(
                type = "Super Sports creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car",
                maxSpeed = 350,
                fuelType = "Racing Fuel",
                seatingCapacity = 2,
                weight = 1000.0,
                color = "Silver"
            )
        )
        println("✅ High-performance vehicle created: ${sportsCar.getVehicleType()}")
        sportsCar.start()
        
        // This should fail - low performance car
        highPerformanceFactory.createVehicleWithProperties(
            VehicleType.CAR,
            VehicleProperties(
                type = "Economy creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car",
                maxSpeed = 120, // Too slow
                fuelType = "Regular Gasoline",
                seatingCapacity = 5,
                weight = 2500.0, // Too heavy
                color = "White"
            )
        )
    } catch (e: VehicleCreationException) {
        println("❌ Low-performance vehicle rejected: ${e.message}")
    }
}

/**
 * Additional utility functions to demonstrate SOLID principles
 */

/**
 * Vehicle service that depends on Vehicle abstraction (Dependency Inversion)
 */
class VehicleService(private val factory: VehicleFactory) {
    fun createFleet(vehicleTypes: List<VehicleType>): List<Vehicle> {
        return vehicleTypes.map { type -> factory.createVehicle(type) }
    }
    
    fun getVehicleInfo(vehicle: Vehicle): String {
        return "${vehicle.getVehicleType()} - Speed: ${vehicle.getMaxSpeed()} km/h, Fuel: ${vehicle.getFuelType()}"
    }
}

/**
 * Vehicle maintenance service (Single Responsibility Principle)
 */
class VehicleMaintenanceService {
    fun performMaintenance(vehicle: Vehicle) {
        println("🔧 Performing maintenance on ${vehicle.getVehicleType()}")
        vehicle.stop()
        println("🔧 Maintenance completed for ${vehicle.getVehicleType()}")
        vehicle.start()
    }
}
