import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        FuelType fuelType = FuelType.ELECTRIC; // Assuming you have an ELECTRIC FuelType
        double currentFuel = 50.0;
        double maxFuel = 100.0;
        Engine engine = new Engine(fuelType, currentFuel, maxFuel);

        assertEquals(fuelType,engine.getFuelType());//bro what does this method want from me
        assertEquals(currentFuel,engine.getCurrentFuel());
        assertEquals(maxFuel,engine.getMaxFuel());
        
    }

    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC,60.0,100.0);
        engine.go();
        assertEquals(40.0,engine.getCurrentFuel());
        engine.go();
        assertEquals(20.0, engine.getCurrentFuel());
        engine.go();
        assertFalse(assertEquals(0.0,engine.getCurrentFuel()));
    
        
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car car new Car(new Arraylist<>(),4);
        Passenger p1 = new Passenger("Lyna");
        assertTrue(car.addPassenger(p1));
        assertEquals(3,car.seatsRemaining());
        Passenger p3 = new Passenger("Ayesha");
        Passenger p4 = new Passenger("Radiah");
        assertTrue(car.addPassenger(p3));
        assertTrue(car.addPassenger(p4));
        assertEquals(1,car.seatsRemaining());
        
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger p3 = new Passenger("Ayesha");
        Passenger p5 = new Passenger("Nahian");

        passengers.add(p5);
        passengers.add(p3); //should i be using an accessor?

        Car car = new Car(passengers,4);
        assertTrue(car.removePassenger(p3));

        assertEquals(1, car.seatsRemaining());

        Passenger p2 = new Passenger("Meron");

        assertFalse(car.removePassenger(p2));

        assertEquals(4, car.seatsRemaining());


        
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p5 = new Passenger("Nahian");
        Car car = new Car(new ArrayList<>(), 1);

        p5.boardCar(car);
        assertEquals(0,car.seatsRemaining());
        assertEquals("Nahian", car.getPassengers().get(0).getName());
        

    }

    @Test
    public void testPassengerBoardCarFull() {
        
        Passenger p3 = new Passenger("Ayesha");
        Passenger p5 = new Passenger("Nahian");
        Passenger p2 = new Passenger("Meron");

        Car car = new Car(new ArrayList<>(), 2);

        p2.boardCar(car);
        p3.boardCar(car);

        p5.boardCar(car);

        assertEquals(2, car.getPassengers().size());
        

    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.0;
        int nCars = 3;
        int passengerCapacity = 50;

        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);

      // 
        assertEquals(nCars + 1, train.getCars.size()); //check if cars is an array or an arraylist

      //is this right to check if a car isn't empty first then to check if it isn't 
        assertNotNull(train.getCar(0)); // Check the first car
        assertEquals(passengerCapacity, train.getCar(0).getCapacity());
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
