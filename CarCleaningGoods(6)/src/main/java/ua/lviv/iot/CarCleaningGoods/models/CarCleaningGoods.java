
package ua.lviv.iot.CarCleaningGoods.models;

public class CarCleaningGoods {

  private String name;
  private String producer;
  private String country;
  private int salesPerDay;
  private double price;
  private Quality quality;
   
  public CarCleaningGoods() {
  
  }

    public CarCleaningGoods(final String name, final String producer, 
            final String country, final int salesPerDay,
            final double price, final Quality quality) {
    this.name = name;
    this.producer = producer;
    this.country = country;
    this.salesPerDay = salesPerDay;
    this.price = price;
    this.quality = quality;
  }

    public String getHeaders() {

        return "name" + ", " + "producer" + ", " + "country" + ", "

            + "salesPerDay" + ", " + "price" + ", " + "quality";

      }



      public String toCSV() {

        return name + ", " + producer + ", " + country

            + ", " + salesPerDay + ", " + price + ", " + quality;

      }
            
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(final String producer) {
    this.producer = producer;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  public int getSalesPerDay() {
    return salesPerDay;
  }

  public void setSalesPerDay(final int salesPerDay) {
    this.salesPerDay = salesPerDay;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(final double price) {
    this.price = price;
  }

  public Quality getQuality() {
    return quality;
  }

  public void setQuality(final Quality quality) {
    this.quality = quality;
  }


  public String toString() {

      return "CarCleaningGoods: \n[\n  " + getHeaders() 
      + "\n  " + toCSV() + "\n]\n";

    }

}
