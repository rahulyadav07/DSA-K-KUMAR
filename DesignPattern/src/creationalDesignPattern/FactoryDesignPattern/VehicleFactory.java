package creationalDesignPattern.FactoryDesignPattern;

public class VehicleFactory {
    public Vehicle getVehicle(String type) throws VehicleNotFound {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        }
        else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }else{
            throw new VehicleNotFound("Vehicle Not Found");
        }
    }
}

class VehicleNotFound extends Exception {
    public VehicleNotFound(String message) {
        super(message);
    }
}