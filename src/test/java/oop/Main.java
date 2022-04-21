package oop;

public class Main {

    public static void main(String[] args) {

        // POLYMORPHISM
        Bike bikeGood = new Bike("Workable bike.");
        System.out.println( bikeGood ); //<-- method toString() override (polymorphism)
        bikeGood.start();
        bikeGood.brake();

        // INHERITANCE (bike inherits from the vehicle)
        Vehicle bikeDamaged = new Bike("Broken bike.");
        System.out.println(bikeDamaged);  // <-- method toString() override (polymorphism)
        bikeDamaged.start();
        // bikeDamaged.brake(); // <- Object of type Vehicle don't have access to brake() method.

        // ABSTRACTION - Cannot create instance of abstract class:
        // Vehicle vehicle = new Vehicle();

        // ENCAPSULATION -> model and getModel are not accessible:
        // System.out.println( bikeGood.model );
        // System.out.println( bikeGood.getModel() );
    }
}
