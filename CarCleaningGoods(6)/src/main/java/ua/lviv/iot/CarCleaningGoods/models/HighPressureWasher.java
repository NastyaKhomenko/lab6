/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.lviv.iot.CarCleaningGoods.models;

public class HighPressureWasher extends CarCleaningGoods {
    private int power;

    public HighPressureWasher() {

    }

    public HighPressureWasher(final String name, 
            final String producer, final String country, final int salesPerDay,
            final double price, final Quality quality, final int power) {
        super(name, producer, country, salesPerDay, price, quality);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(final int power) {
        this.power = power;
    }

    public String getHeaders() {

        return super.getHeaders() + ", " + "power";

      }



      public String toCSV() {

        return super.toCSV() + ", " + power;

      }

}
