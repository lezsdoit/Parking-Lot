package com.company.service;

import com.company.entity.Car;
import com.company.entity.ParkingLot;
import com.company.entity.Slot;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ParkCar {
    public Long park(Car car, ParkingLot parkingLot){

        Long slotNumber = null;
        slotNumber = getSlotNumber(parkingLot);


        if(slotNumber==-1L){
            System.out.println("No space to park");
            return slotNumber;
        }
        Slot slot = new Slot(slotNumber,car);
        Long id = parkingLot.addSlot(slot);
        System.out.println("Allocated slot number: "+id);
        parkingLot.getPriorityQueue().add(slotNumber);
        return slotNumber;
    }

    public Long getSlotNumber(ParkingLot parkingLot){
        PriorityQueue<Long> priorityQueue = parkingLot.getPriorityQueue();
        Long x = Long.valueOf(priorityQueue.size());

        Long capacity = parkingLot.getCapacity();

        if(x==capacity)
        {
            System.out.println("Not enough capacity");
            return Long.valueOf(-1);
        }

        Iterator it = priorityQueue.iterator();
        Long l = 1L;
        while (it.hasNext()){
            if(it.next()==l){
                l++;
            }
            else {
                break;
            }
        }
       return l;
    }
}
