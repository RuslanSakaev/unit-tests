package seminars.second.hw;

import org.example.seminars.second.hw.Car;
import org.example.seminars.second.hw.Motorcycle;
import org.example.seminars.second.hw.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Honda", "Civic", 2006);
        motorcycle = new Motorcycle("Yamaha", "Bolt", 2017);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorcycleHasTwoWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void testCarSpeed() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testMotorcycleSpeed() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void testCarPark() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testMotorcyclePark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
