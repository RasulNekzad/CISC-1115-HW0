# HW7 

This program outlines classes for Car, FuelGauge, and Odometer objects and utilizes them to simulate a car being filled up on gas and being driven until it's out of fuel, accelerating and braking at set intervals all the while. 

The Car class has FuelGauge and Odometer objects as fields, and its constructor creates a new instance of each.  This makes it possible to call methods from those classes on Car objects.

For example, to fill a Car object, car1, with fuel, we can say: `car1.fuelGauge.incrementGallons();`
