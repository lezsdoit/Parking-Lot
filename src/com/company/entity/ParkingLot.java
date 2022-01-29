package com.company.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ParkingLot {
    private String name;
    private Long parkingLotId;
    private Long capacity;
    private List<Slot> slots;
    private PriorityQueue<Long> priorityQueue;

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public PriorityQueue<Long> getPriorityQueue() {
        return priorityQueue;
    }

    public void setPriorityQueue(PriorityQueue<Long> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public Long addSlot(Slot slot){
        this.slots.add(slot);
        return slot.getSlotNumber();
    }

    public Long removeSlot(Slot slot){
        slots.remove(slot);
        return slot.getSlotNumber();
    }

    public ParkingLot(Long capacity) {
        this.capacity = capacity;
        priorityQueue = new PriorityQueue<>();
        slots = new ArrayList<>();
    }
}
