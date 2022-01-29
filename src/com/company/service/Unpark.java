package com.company.service;

import com.company.entity.ParkingLot;
import com.company.entity.Slot;
import java.util.List;

public class Unpark {
    public static void exit(Long slotNumber, ParkingLot parkingLot){
        List<Slot> slots = parkingLot.getSlots();
        for (int i=0;i<slots.size();i++){
            if(slots.get(i).getSlotNumber()==slotNumber){
                System.out.println("Slot Number "+slotNumber+" is free");
                slots.remove(i);
                parkingLot.getPriorityQueue().remove(slotNumber);
                return;
            }
        }
        System.out.println("It's already empty");
    }
}
