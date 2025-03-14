public class Engine implements EngineRequirements {

    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;
    
    /**
     * Constructor for Engine 
     * @param f Enine's fuel type 
     * @param currentFuelLevel Engine's current fuel level 
     * @param maxFuelLevel Engine's max fuel level 
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f; 
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel; 
    }

    /**
     * Gets the fuel type of the engine.
     *
     * @return The fuel type of the engine.
     */
    public FuelType getFuelType() {
        return f; 
    }

    /**
     * Gets the maximum fuel level of the engine.
     *
     * @return The maximum fuel level.
     */
    public double getMaxFuel() {
        return maxFuelLevel; 
    }

    /**
     * Gets the current fuel level of the engine.
     *
     * @return The current fuel level.
     */
    public double getCurrentFuel() {
        return currentFuelLevel; 
    }

    /**
     * Refuels the engine to its maximum fuel level.
     */
    public void refuel() {
        this.currentFuelLevel = maxFuelLevel;

    }

    /**
     * Simulates the engine moving- going, decreasing the fuel level.
     *
     * @return True if the engine has fuel, false otherwise.
     */
    public Boolean go() {
        this.currentFuelLevel = this.currentFuelLevel - 20.0;
        System.out.println("Remaining fuel level : "+ this.currentFuelLevel);
        if(currentFuelLevel>0){
            return true;}
        else{
        return false;
    }
    }
    /**
     * Returns a string representation of the engine.
     *
     * @return A string describing the engine.
     */
    public String toString() {
        return ("Engine has fuel type: " + this.f + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel); 
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0,100.0);

        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}







