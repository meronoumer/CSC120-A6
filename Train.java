
import java.util.ArrayList;

/**
 * Represents a Train with an Engine and a collection of Cars.
 */
public class Train implements TrainRequirements{
    //-  an `ArrayList` to keep track of the `Car`s currently attached
    private ArrayList <Car> cars;
    private Engine engine;
 

 /**
  * Constructs a Train object with the given fuel type, fuel capacity, number of cars, and passenger capacity.
  * 
  * @param fuelType         The fuel type of the engine.
  * @param fuelCapacity     The maximum fuel capacity of the engine.
  * @param nCars            The number of cars in the train.
  * @param passengerCapacity The passenger capacity of each car.
*/  

 public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
   this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
   this.cars = new ArrayList <Car>() ;

   
   for (int i = 0; i <= nCars;i++){
      this.cars.add(new Car(passengerCapacity)); //im confused cause it keeps telling me the constructor is undefines
   }


 }
/**
 * Gets the Engine of the train.
 *
 *  @return The Engine object.
 */
 public Engine getEngine(){
    return this.engine;
 }

 /**
  * Gets the Car at the specified index.
  *
  * @param i The index of the Car.
  * @return The Car object at the specified index.
  */
  
 public Car getCar(int i){
   if(i<cars.size() && i>=0){
      return this.cars.get(i);
   }else{
      return null;
   }
    
 }

 public ArrayList getCars(){
   return this.cars;
 }

 /**
  * Calculates the maximum passenger capacity of the train.
  * 
  * @return The total passenger capacity.
  */
 public int getMaxCapacity(){
      int totalCapacity = 0;
      for (int i = 0; i < this.cars.size();i++){
         
        totalCapacity += this.cars.get(i).getCapacity();
      }

    return totalCapacity;
 }
 /**
  * Calculates the total number of remaining seats in the train.
  * 
  * @return The total number of remaining seats.
  */

 public int seatsRemaining(){
   int seatsRemaining = 0;
   for (int i = 0; i < this.cars.size();i++) {
      seatsRemaining += this.cars.get(i).seatsRemaining();
      
    }return seatsRemaining;
      
   
   }

 /**
  * Prints the passenger manifest of the train.
  */  
 public void printManifest(){
   boolean isEmpty = true;
   for (Car car:cars){
      if (car.seatsRemaining()<car.getCapacity()){
         isEmpty = false;
         car.printManifest();}

      }
      
      if(isEmpty){ 
            System.out.println("This train is empty.");
      }

         
   
      
   
 }
 public static void main(String[] args) {
   Train myTrain = new Train(FuelType.ELECTRIC, 100.0, 2, 5);

   System.out.println("Initial Train Manifest:");
   myTrain.printManifest();
   System.out.println();

   Car firstCar = myTrain.getCar(0);
   if (firstCar != null) {
       firstCar.addPassenger(new Passenger("Meron"));
       firstCar.addPassenger(new Passenger("Nahian"));
   }

   System.out.println("Train Manifest after adding passengers to the first car:");
   myTrain.printManifest();
   System.out.println();

   Car secondCar = myTrain.getCar(1);
   if (secondCar != null) {
       secondCar.addPassenger(new Passenger("Charlie"));
   }

   System.out.println("Train Manifest after adding passengers to both cars:");
   myTrain.printManifest();
}





}




