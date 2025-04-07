import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TrainTest {

    // Engine Tests
    /**
    *Verifies that the Engine constructor initializes correctly with the given FuelType and fuel level.
    *
    */ 
    @Test
    public void testEngineConstructor() {
        FuelType fuelType = FuelType.ELECTRIC; 
        double currentFuel = 50.0;
        double maxFuel = 100.0;
        Engine engine = new Engine(fuelType, currentFuel, maxFuel);

        assertEquals(fuelType,engine.getFuelType());
        assertEquals(currentFuel,engine.getCurrentFuel(),0.5);
        assertEquals(maxFuel,engine.getMaxFuel(),0.5);
        
    }

    /**
     * Ensure that fuel consumption reduces the fuel level correctly
     */ 
     
    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC,60.0,100.0);
        engine.go();
        assertEquals(40.0,engine.getCurrentFuel(),0.5);
        engine.go();
        assertEquals(20.0, engine.getCurrentFuel(),0.5);
        engine.go();
        assertEquals(0.0,engine.getCurrentFuel(),0.5);
    
        
    }

    // Car Tests
    /**
     * Verifying that adding a passenger increases the passenger count.
     */
    @Test
    public void testCarAddPassenger() {
        Car car2  = new Car(4);
        Passenger p1 = new Passenger("Lyna");
        assertTrue(car2.addPassenger(p1));
        assertEquals(3,car2.seatsRemaining());
        Passenger p3 = new Passenger("Ayesha");
        Passenger p4 = new Passenger("Radiah");
        assertTrue(car2.addPassenger(p3));
        assertTrue(car2.addPassenger(p4));
        assertEquals(1,car2.seatsRemaining());
        
    }

    /**
     * Checking that removing a passenger decreases the count and that it doesn't go into negatives.
     */
    @Test
    public void testCarRemovePassenger() {
        Passenger p3 = new Passenger("Ayesha");
        Passenger p5 = new Passenger("Nahian");

        //declare passengers
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();

         

        Car car3 = new Car(4);
        
        assertTrue(car3.addPassenger(p5)); 
        assertTrue(car3.addPassenger(p3));
        assertTrue(car3.removePassenger(p3));

        assertEquals(3, car3.seatsRemaining());

        Passenger p2 = new Passenger("Meron");

        assertFalse(car3.removePassenger(p2));

        assertEquals(3, car3.seatsRemaining());


        
    }

    // Passenger Tests

    /**
     * Tests that a passenger can successfully board a car.
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p5 = new Passenger("Nahian");
        Car car = new Car( 1);

        p5.boardCar(car);
        assertEquals(0,car.seatsRemaining());
        assertEquals("Nahian", car.getPassengers().get(0).getName());
        

    }
    /**
     * Ensures that a passenger cannot board a full car.
     */

    @Test
    public void testPassengerBoardCarFull() {
        
        Passenger p3 = new Passenger("Ayesha");
        Passenger p5 = new Passenger("Nahian");
        Passenger p2 = new Passenger("Meron");

        Car car = new Car( 2);

        p2.boardCar(car);
        p3.boardCar(car);

        p5.boardCar(car);

        assertEquals(2, car.getPassengers().size());
        

    }

    // Train Tests

    /**
     * Verify that a train initializes correctly with a given number of Car s.
     */
    @Test
    public void testTrainConstructor() {
        FuelType fuelType = FuelType.ELECTRIC;
        double fuelCapacity = 100.0;
        int nCars = 3;
        int passengerCapacity = 50;

        Train train = new Train(fuelType, fuelCapacity, nCars, passengerCapacity);

      
        assertEquals(nCars + 1, train.getCars().size()); 

        assertNotNull(train.getCar(0)); 
        assertEquals(passengerCapacity, train.getCar(0).getCapacity());
    }

    /**
     * Ensures that the entire train's total Passenger count updates as passengers board and leave
     */
    @Test
    public void testTrainPassengerCount() {
        Passenger p6 = new Passenger("Lola");
        Passenger p7 = new Passenger("Maya");
        Passenger p8 = new Passenger("Jeff");
        Passenger p9 = new Passenger("Sherlock");
        Train train = new Train(FuelType.ELECTRIC, 100.0, 2, 50); 

        Car trainCar1 = train.getCar(0);
        Car trainCar2 = train.getCar(1);


        p6.boardCar(trainCar1);
        assertEquals(1, trainCar1.getPassengers().size()); 
        p7.boardCar(trainCar1);
        assertEquals(2, trainCar1.getPassengers().size()); 

        p8.boardCar(trainCar2);
        assertEquals(1, trainCar2.getPassengers().size()); 

        p9.boardCar(trainCar2);
        assertEquals(2, trainCar2.getPassengers().size()); 

        p6.getOffCar(trainCar1);
        assertEquals(1, trainCar1.getPassengers().size()); 

        assertEquals(3,trainCar1.getPassengers().size() + trainCar2.getPassengers().size());
    }

    /**
     * Checks that getCar() returns the expected car
     */
    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 2, 10); 

        assertNotNull(train.getCar(0));
        assertEquals(10,train.getCar(0).getCapacity());

        assertNotNull(train.getCar(1));
        assertEquals(10,train.getCar(1).getCapacity());

        assertNull(train.getCar(4));
        assertEquals(10, train.getCar(2).getCapacity());




    }
    /***
     * Checks printManifest() to make sure that it iterates through the cars correctly
     */
    @Test
    public void testTrainPrintManifest()
    //chat gpt was used to help make this unit test ,but it was used in office hours as me and Professor Jordan worked on it together
    
    {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 2, 3); 
        ByteArrayOutputStream outcontent = new ByteArrayOutputStream();
        PrintStream originalout = System.out;

        System.setOut(new PrintStream(outcontent));

        try{
            train.printManifest();
        

        String expected = "This train is empty.";

        assertEquals(expected, outcontent.toString().strip());
    }
        finally{
            System.setOut(originalout);
        }
        

         
      
         
    


        }









        
    }
    
    
