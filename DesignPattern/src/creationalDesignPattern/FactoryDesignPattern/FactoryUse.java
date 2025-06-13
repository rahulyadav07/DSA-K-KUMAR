package creationalDesignPattern.FactoryDesignPattern;

public class FactoryUse {
    /**
     *
     * Builder Pattern is a creational design pattern that helps in constructing complex objects step-by-step,
     * especially when the object has many optional parameters.
     * It avoids the need for multiple constructors and improves code readability and flexibility.
     *
     * @throws VehicleNotFound if you try to create that object which not handle in factory that will throw the error.
     */


    /**
     * PROS
     *
     * Because builder pattern helps avoid constructor overloads, improves readability with method chaining,
     * and provides better flexibility and immutability when creating complex objects
     */
    public static void main(String[] args) throws VehicleNotFound {

        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.getVehicle("car");
        car.start();

        Vehicle bike = factory.getVehicle("bike");
        bike.start();

        Vehicle bus = factory.getVehicle("bus");
        bus.start();
    }
}
