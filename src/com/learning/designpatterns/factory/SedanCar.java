package com.learning.designpatterns.factory;

public class SedanCar extends Car {

    public SedanCar(){
        super(CarType.SEDAN);
        construct();
    }
    @Override
    protected void construct() {

    }
}
