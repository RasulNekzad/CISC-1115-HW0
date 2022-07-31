public class HW7 {

  public static void main(String[] args) {
    // Calls Car constructor which creates an instance of Car,
    // as well as instances of FuelGauge and Odometer since they are fields of Car.
    Car car = new Car(2019, "Toyota");
    // Fills fuel gauge to max.
    for (int i = 0; i < FuelGauge.MAX_GALLONS; i++) {
      car.fuelGauge.incrementGallons();
    }

    // Creates counter variable to count number of iterations.
    int count = 0;
    while (car.fuelGauge.getGallons() > 0) {
      count++;
      // Increments car's mileage.
      car.odometer.incrementMileage(car.fuelGauge);
      // If current increment of count is a multiple of 5, calls brake method,
      // which decreases speed and prints current speed.
      if (count % 5 == 0) {
        car.brake();
      } else {
        car.accelerate(); // Otherwise, call accelerate.
      }
      System.out.println("Current mileage: " + car.odometer.getMileage());
      System.out.printf("Fuel remaining (gallons): %.2f\n", car.fuelGauge.getGallons());
    }
  }
}

class Car {

  int yearModel;
  String make;
  int speed;

  public FuelGauge fuelGauge;

  public Odometer odometer;

  public Car(int yearModel, String make) {

    this.yearModel = yearModel;
    this.make = make;
    speed = 0;

    fuelGauge = new FuelGauge();
    odometer = new Odometer();
  }

  public int getYearModel() {
    return yearModel;
  }

  public String getMake() {
    return make;
  }

  public int getSpeed() {
    return speed;
  }

  public void accelerate() {
    speed += 5;
  }

  public void brake() {
    speed -= 5;
    fuelGauge.decrementGallons(); // decrease fuel
    System.out.println("Current speed: " + speed);
  }
}

class FuelGauge {

  private double gallons;
  public static final double MAX_GALLONS = 15;

  public double getGallons() {
    return gallons;
  }

  public void incrementGallons() {
    if (gallons < MAX_GALLONS) {
      gallons += 1;
    }
  }

  public void decrementGallons() {
    if (gallons > 0) {
      gallons -= (1 + Math.random());
      if (gallons < 0) {
        gallons = 0;
      }
    }
  }
}

class Odometer {

  private int mileage;
  public static final int MAX_MILEAGE = 999999;

  public int getMileage() {
    return mileage;
  }

  public void incrementMileage(FuelGauge fuelGauge) {
    mileage++;
    if (mileage >= MAX_MILEAGE) {
      mileage = 0;
    }
    // Decrement fuel by 1 gallon per 24 miles.
    if (mileage % 24 == 0) {
      fuelGauge.decrementGallons();
    }
  }
}
