package activities;

public class Activity1 extends Car {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car Ford = new Car();
		Ford.make = 2014;
		Ford.Color = "Black";
		Ford.Transmission = "Manual";
		
		Ford.displayCharacteristics();
		Ford.accelarate();
		Ford.brake();

	}

}
