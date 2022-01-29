package com.company;

import com.company.entity.Car;
import com.company.entity.ParkingLot;
import com.company.entity.Slot;
import com.company.service.Display;
import com.company.service.ParkCar;
import com.company.service.Search;
import com.company.service.Unpark;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ParkingLot parkingLot = null;
        ParkCar  parkCar = null;
        Search search = null;
        while(true){
            System.out.println("Hii");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals("create_parking_lot")){
                Long size = scanner.nextLong();
                parkingLot = new ParkingLot(size);
                parkCar = new ParkCar();
                search = new Search();
                System.out.println("Parking Lot created with capacity "+ parkingLot.getCapacity());
            }
            else if(command.equals("park")){
                String registrationNumber = scanner.nextLine();
                String color = scanner.nextLine();
                Car car = new Car(registrationNumber,color);
                try {
                    parkCar.park(car,parkingLot);
                }
                catch (Exception exception){
                    System.out.println("Failed to park");
                    System.out.println(exception.getMessage());
                }
            }
            else if(command.equals("status")){
                Display.showStatus(parkingLot);
            }
            else if(command.equals("leave")){
                Long slotNumber = scanner.nextLong();
                Unpark.exit(slotNumber,parkingLot);
            }
            else if(command.equals("registration_numbers_for_cars_with_colour")){
                String color = scanner.nextLine();
                List<Car> cars = search.getAllCarByColor(color,parkingLot.getSlots());
                for (Car car:cars){
                    System.out.println(car.getRegistrationNumber());
                }
            }
            else if(command.equals("slot_numbers_for_cars_with_colour")){
                String color = scanner.nextLine();
                List<Long> slots = search.getSlotByColor(color,parkingLot.getSlots());
                for(Long l:slots){
                    System.out.println(l);
                }
            }
            else if (command.equals("slot_number_for_registration_number")){
                String registrationNumber = scanner.nextLine();
                Long slotNumber = search.getSlotByRegistration(registrationNumber,parkingLot.getSlots());
                if(slotNumber==-1){
                    System.out.println("Not found");
                }
                else {
                    System.out.println("Parked at slot : "+slotNumber);
                }
            }
            else {
                System.out.println("Invalid Command");
            }
        }
    }
}
