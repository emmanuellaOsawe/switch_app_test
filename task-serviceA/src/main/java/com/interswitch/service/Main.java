package com.interswitch.service;

public class Main {

    private double secondNumber;
    private double firstNumber;

    void SimpleCalculator(double first, double second) {
        this.firstNumber = first;
        this.secondNumber = second;
    }

    public static double addTwoNumbers(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        addTwoNumbers(20, 60);
    }
}