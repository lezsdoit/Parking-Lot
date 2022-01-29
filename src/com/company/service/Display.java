package com.company.service;

import com.company.entity.ParkingLot;
import com.company.entity.Slot;

import java.util.List;

public class Display {
    public static void showStatus(ParkingLot parkingLot){
        List<Slot> slots = parkingLot.getSlots();
        System.out.println("Slot     Registration number   Colour");
        for (Slot slot:slots){
            System.out.println(slot.getSlotNumber()+"       "+slot.getCar().getRegistrationNumber()+"         "+slot.getCar().getColour());
        }
    }
}
