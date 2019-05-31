/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.lviv.iot.CarCleaningGoods.models;

public class Detergent extends CarCleaningGoods {
    private double capacity;
    private String appliance;

    public Detergent() {

    }
    
    public Detergent(final String name, final String producer, 
            final String country, final int salesPerDay,
            final double price, final Quality quality,
            final double capacity, final String appliance) {
        super(name, producer, country, salesPerDay, price, quality);
        this.capacity = capacity;
        this.appliance = appliance;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(final double capacity) {
        this.capacity = capacity;
    }

    public String getAppliance() {
        return appliance;
    }

    public void setAppliance(final String appliance) {
        this.appliance = appliance;
    }

    public String getHeaders() {

        return super.getHeaders() + ", " + "capacity" + ", " + "appliance";

      }



      public String toCSV() {

        return super.toCSV() + ", " +  capacity + ", " + appliance;

      }

}
