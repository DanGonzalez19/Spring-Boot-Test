package com.javatest.SpringbootTest.models;

import java.util.ArrayList;

public class Arrays {

    ArrayList<Supply> supplies = new ArrayList<>();
    ArrayList<Demand> demands = new ArrayList<>();
    ArrayList<Inventory> inventories = new ArrayList<>();
    ArrayList<Calendar> calendars = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();


    public Arrays(){
        supplies.add(new Supply("Product1",10));
        supplies.add(new Supply ("Product2",5));

        demands.add(new Demand("Product1",2));
        demands.add(new Demand("Product2",5));

        inventories.add(new Inventory("Prod1","Shirt","EACH", 10.0, "2021-03-19"));
        inventories.add(new Inventory ("Prod1","Shirt","EACH", 20.0,"2021-03-21"));
        inventories.add(new Inventory ("Prod1","Shirt","EACH", 20.0,"2021-03-28"));

        calendars.add(new Calendar("STORE001", "ALL", "13:30"));
        calendars.add(new Calendar("STORE002", "SUNDAY", "13:30"));
        calendars.add(new Calendar("STORE003", "MONDAY", "13:30"));
    
        days.add("EMPTY");
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        days.add("SATURDAY");
        days.add("SUNDAY");


    }

    public ArrayList<Supply> getSupplies() {
        return supplies;
    }

    public ArrayList<Demand> getDemands() {
        return demands;
    }

    public ArrayList<Inventory> getInventories() {
        return inventories;
    }
    public ArrayList<Calendar> getCalendars() {
        return calendars;
    }

    public String getDayString(int day){
        System.out.println(day);
        return days.get(day);
    }
}
