import creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Bike
import creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car

/**
 * Vehicle Factory interface following Open/Closed Principle (OCP)
 * This interface is open for extension but closed for modification
 * 
 * SOLID Principles Applied:
 * - Open/Closed: Can be extended with new vehicle types without modifying existing code
 * - Dependency Inversion: Depends on abstractions (Vehicle interface)
 * - Interface Segregation: Only essential factory methods
 */
interface VehicleFactory {
    fun createVehicle(vehicleType: VehicleType): Vehicle
    fun createVehicleWithProperties(vehicleType: VehicleType, properties: VehicleProperties): Vehicle
    fun getSupportedVehicleTypes(): List<VehicleType>
}

/**
 * Vehicle type enum for type safety
 */
enum class VehicleType(val displayName: String) {
    CAR("creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car"),
    BIKE("creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Bike"),
    TRUCK("Truck")
}

/**
 * Custom exception for vehicle creation errors
 */
class VehicleCreationException(message: String) : Exception(message)

/**
 * Concrete Vehicle Factory implementation following SOLID principles
 * 
 * SOLID Principles Applied:
 * - Single Responsibility: Only responsible for creating vehicles
 * - Open/Closed: Can be extended without modification
 * - Liskov Substitution: Can be substituted for VehicleFactory interface
 * - Interface Segregation: Implements only necessary methods
 * - Dependency Inversion: Depends on Vehicle abstraction
 */
class ConcreteVehicleFactory(
    private val validator: VehicleValidator = DefaultVehicleValidator()
) : VehicleFactory {
    
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.CAR -> Car()
            VehicleType.BIKE -> Bike()
            VehicleType.TRUCK -> Truck()
        }
    }
    
    override fun createVehicleWithProperties(vehicleType: VehicleType, properties: VehicleProperties): Vehicle {
        // Validate properties before creating vehicle
        if (!validator.validate(properties)) {
            throw VehicleCreationException("Invalid vehicle properties: $properties")
        }
        
        return when (vehicleType) {
            VehicleType.CAR -> Car(properties)
            VehicleType.BIKE -> Bike(properties)
            VehicleType.TRUCK -> Truck(properties)
        }
    }
    
    override fun getSupportedVehicleTypes(): List<VehicleType> {
        return VehicleType.values().toList()
    }
}

/**
 * Specialized factory for electric vehicles following Open/Closed Principle
 * This demonstrates how we can extend the factory without modifying existing code
 */
class ElectricVehicleFactory(
    private val validator: VehicleValidator = DefaultVehicleValidator()
) : VehicleFactory {
    
    override fun createVehicle(vehicleType: VehicleType): Vehicle {
        val electricProperties = when (vehicleType) {
            VehicleType.CAR -> VehicleProperties(
                type = "Electric creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Car",
                maxSpeed = 180,
                fuelType = "Electric",
                seatingCapacity = 5,
                weight = 1800.0,
                color = "Green"
            )
            VehicleType.BIKE -> VehicleProperties(
                type = "Electric creationalDesignPattern.FactoryDesignPattern.kotlinsolid.Bike",
                maxSpeed = 100,
                fuelType = "Electric",
                seatingCapacity = 2,
                weight = 250.0,
                color = "Green"
            )
            VehicleType.TRUCK -> VehicleProperties(
                type = "Electric Truck",
                maxSpeed = 80,
                fuelType = "Electric",
                seatingCapacity = 3,
                weight = 10000.0,
                color = "Green"
            )
        }
        
        return createVehicleWithProperties(vehicleType, electricProperties)
    }
    
    override fun createVehicleWithProperties(vehicleType: VehicleType, properties: VehicleProperties): Vehicle {
        // Ensure it's an electric vehicle
        val electricProperties = properties.copy(fuelType = "Electric")
        
        if (!validator.validate(electricProperties)) {
            throw VehicleCreationException("Invalid electric vehicle properties: $electricProperties")
        }
        
        return when (vehicleType) {
            VehicleType.CAR -> Car(electricProperties)
            VehicleType.BIKE -> Bike(electricProperties)
            VehicleType.TRUCK -> Truck(electricProperties)
        }
    }
    
    override fun getSupportedVehicleTypes(): List<VehicleType> {
        return VehicleType.values().toList()
    }
}
