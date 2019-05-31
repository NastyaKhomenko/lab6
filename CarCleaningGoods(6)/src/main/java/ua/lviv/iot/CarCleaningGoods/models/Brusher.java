/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.lviv.iot.CarCleaningGoods.models;

public class Brusher extends CarCleaningGoods {
    private String stiffness;
    private Convenience convenience;

    public Brusher() {

    }

    public Brusher(final String name, final String producer, 
            final String country, 
            final int salesPerDay,
            final double price, final Quality quality, 
            final String stiffness, final Convenience convenience) {
        super(name, producer, country, salesPerDay, price, quality);
        this.stiffness = stiffness;
        this.convenience = convenience;
    }

    public String getStiffness() {
        return stiffness;
    }

    public void setStiffness(final String stiffness) {
        this.stiffness = stiffness;
    }

    public Convenience getConvenience() {
        return convenience;
    }

    public void setConvenience(final Convenience convenience) {
        this.convenience = convenience;
    }

    public String getHeaders() {

        return super.getHeaders() + ", " + "stiffness" + ", " + "convienience";

      }



      public String toCSV() {

        return super.toCSV() + ", " + stiffness + ", " + convenience;

      }

}
