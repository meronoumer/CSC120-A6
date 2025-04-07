
/**
 * Passenger Class with a name and the ability to board and get off a Car.
 */

 public class Passenger implements PassengerRequirements {
    
    private String name;

    /**
     * Constructs a Passenger object with the given name.
     *
     * @param name The name of the passenger.
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Attempts to board the given Car.
     *
     * @param c The Car to board.
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println(this);
            
        }
        else
        {
            System.out.println("This car is full.");
        }
        
    }

    /**
     * Attempts to get off the given Car.
     *
     * @param c The Car to get off.
     */
    public void getOffCar(Car c){
        if(!c.removePassenger(this)){
            System.out.println("Customer already off car");
        }else{
            System.out.println(this);
        }
    }

    public String getName(){
        return name;

    }


    public String toString() {
        return name; //does this fix the whole print manifest spiiting out hexcodes thing?
    }




}

