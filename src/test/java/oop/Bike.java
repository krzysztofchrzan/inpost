package oop;

class Bike extends Vehicle {
    public final String model;

    private String getModel() {
        return model;
    }

    public Bike(String model) {
        this.model = model;
    }

    // Implementation of abstract method:
    public void start(){
        System.out.println("Bike is moving.");
    }

    public void brake() {
        System.out.println("Bike is braking.");
    }

    @Override
    public String toString() {
        return "Method toString override:{" +
                "model='" + model + '\'' +
                '}';
    }
}
