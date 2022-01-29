package com.company.entity;

public class Slot {
    private Long slotNumber;
    private Car car;

    public Slot(Long slotNumber, Car car) {
        this.slotNumber = slotNumber;
        this.car = car;
    }

    public Long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Long slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
