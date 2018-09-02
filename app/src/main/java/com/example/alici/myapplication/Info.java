package com.example.alici.myapplication;

public class Info{
    public double temp;
    public int numberofman;
    public int distance;
    public double price;
    public double rain;
    public int stay;

    public Info(double temp, int numberofman, int distance, double price, double rain, int stay) {
        this.temp = temp;
        this.numberofman = numberofman;
        this.distance = distance;
        this.price = price;
        this.rain = rain;
        this.stay = stay;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getNumberofman() {
        return numberofman;
    }

    public void setNumberofman(int numberofman) {
        this.numberofman = numberofman;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public int getStay() {
        return stay;
    }

    public void setStay(int stay) {
        this.stay = stay;
    }
}