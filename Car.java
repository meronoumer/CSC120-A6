import java.util.ArrayList;

public class Car implements CarRequirements {

    private ArrayList<Passenger> passengers;
    private int capacity;


/**
 * Constructs a Car object with the given list of passengers and capacity.
 *
     * @param passengers The initial list of passengers in the car.
     * @param capacity   The maximum number of passengers the car can hold.

 */
public Car(ArrayList<Passenger> passengers, int Capacity) {
    this.passengers = new ArrayList<Passenger>(passengers); 
    this.capacity = capacity; 
}

/**
 * Returns the maximum passenger capacity of the car.
 *
 * @return The capacity of the car.
 */
public int getCapacity(){
    return capacity;

}

/**
 * Returns the number of seats remaining in the car.
 *
 * @return The number of available seats.
 */
public int seatsRemaining(){
     
    return this.capacity - this.passengers.size() ;

}


/**
 * Adds a passenger to the car if there is available space.
 *
 * @param p The passenger to add.
 * @return True if the passenger was added successfully, false otherwise.
 */
public Boolean addPassenger(Passenger p){
    if (seatsRemaining() > 0){
        for (Passenger i : this.passengers){
            if(i.getName().equals(p.getName())){ 
                 //isthis supposed to begetname instead cause we're thinking about encapsulation - but also name was never declared a s a private attribute?
//this just checks that there isn't the same person boarding twice cause it loops through the list and then compares each - is this right?
                return false;
            }
        }
        
        this.passengers.add(p);
        return true;    }}


/**
 * Removes a passenger from the car if they are present.
 *
 * @param p The passenger to remove.
 * @return True if the passenger was removed successfully, false otherwise.
 */
public Boolean removePassenger(Passenger p){
    if(this.passengers.contains(p)){
        this.passengers.remove(p);
        return true;//is this the same earlier where two of the exact same people can be onboard with the same name could be on board and is it only checking for just one of them instead of looping through so can i solve it the same way as earlier
        
    }
    else{
        return false;
    }

}

/**
 * Prints the passenger manifest of the car.
 */
public void printManifest(){
    if (this.passengers.size()>0){
        System.out.println("----------------------");
        System.out.println("Passenger Manifest");
        for(Object person : passengers){
            System.out.println(person);
        }System.out.println("----------------------");
    }
    else{
        System.out.println("This car is empty.") ;
    }
    public static void main(String[] args) {
        // Create some passengers
        Passenger passenger1 = new Passenger("Alice");
        Passenger passenger2 = new Passenger("Bob");
        Passenger passenger3 = new Passenger("Charlie");
        Passenger passenger4 = new Passenger("David");

        // Create an ArrayList of passengers
        ArrayList<Passenger> initialPassengers = new ArrayList<>();
        initialPassengers.add(passenger1);
        initialPassengers.add(passenger2);

        // Create a car with a capacity of 4 and initial passengers
        Car myCar = new Car(initialPassengers, 4);

        // Print the initial manifest
        System.out.println("Initial Manifest:");
        myCar.printManifest();

        // Add more passengers
        myCar.addPassenger(passenger3);
        myCar.addPassenger(passenger4);

        // Print the updated manifest
        System.out.println("\nUpdated Manifest after adding more passengers:");
        myCar.printManifest();

        // Attempt to add a duplicate passenger
        Passenger passenger5 = new Passenger("Alice");
        myCar.addPassenger(passenger5);

        System.out.println("\nManifest after attempting to add duplicate:");
        myCar.printManifest();

        // Remove a passenger
        myCar.removePassenger(passenger2);

        // Print the manifest after removal
        System.out.println("\nManifest after removing Bob:");
        myCar.printManifest();

        //Create an empty car and test the empty manifest
        Car emptyCar = new Car(new ArrayList<Passenger>(), 3);
        System.out.println("\nEmpty car manifest:");
        emptyCar.printManifest();
}
}
}