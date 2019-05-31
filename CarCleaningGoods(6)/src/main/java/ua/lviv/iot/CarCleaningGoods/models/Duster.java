/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.lviv.iot.CarCleaningGoods.models;

public class Duster extends CarCleaningGoods {
    private Size size;
    private String material;
    private String color;

    public Duster() {

    }

    public Duster(final String name, final String producer, 
            final String country, final int salesPerDay,
            final double price, final Quality quality,
            final Size size, final String material, final String color) {
        super(name, producer, country, salesPerDay, price, quality);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(final Size size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(final String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getHeaders() {

        return super.getHeaders() + ", " + "size" + ", " + "material" + ", "
        + "color";

      }



      public String toCSV() {

        return super.toCSV() + ", " + size + ", " + material + ", " + color;

      }

}
