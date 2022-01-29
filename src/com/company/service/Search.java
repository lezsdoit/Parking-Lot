package com.company.service;

import com.company.entity.Car;
import com.company.entity.Slot;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Car> getAllCarByColor(String colour,List<Slot> slots){
        List<Car> cars = new ArrayList<>();
        for(Slot slot : slots){
            if(slot.getCar().getColour().equals(colour)){
                cars.add(slot.getCar());
            }
        }
        return cars;
    }

    public Long getSlotByRegistration(String registration, List<Slot> slots){
        Long slotNumber = -1L;
        for(Slot slot:slots){
            if(slot.getCar().getRegistrationNumber().equals(registration)){
                slotNumber=slot.getSlotNumber();
            }
        }
        return slotNumber;
    }

    public List<Long> getSlotByColor(String colour, List<Slot> slots){
        List<Long> list = new ArrayList<>();
        for (Slot slot:slots){
            if(slot.getCar().getColour().equals(colour)){
                list.add(slot.getSlotNumber());
            }
        }
        return list;
    }
}
