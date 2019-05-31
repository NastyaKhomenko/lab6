package ua.lviv.iot.CarCleaningGoods.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.CarCleaningGoods.models.Brusher;
import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;
import ua.lviv.iot.CarCleaningGoods.models.Convenience;
import ua.lviv.iot.CarCleaningGoods.models.Detergent;
import ua.lviv.iot.CarCleaningGoods.models.Duster;
import ua.lviv.iot.CarCleaningGoods.models.HighPressureWasher;
import ua.lviv.iot.CarCleaningGoods.models.Quality;
import ua.lviv.iot.CarCleaningGoods.models.Size;


public class CarCleaningGoodsWriterTest {
    
    private List<CarCleaningGoods> goods;
    
    public void setUp() {
        goods = new ArrayList<>();
    }

    @BeforeEach
    public void beforeEach() {
        goods = new ArrayList<>();
    
        goods.add(new CarCleaningGoods(
                "Brusher", "Rock", "Germany", 40, 45, Quality.BAD));
        goods.add(new Brusher("Brusher", 
                "Rock", "Poland", 10, 30, Quality.BAD, "light",
                Convenience.COMFORTABLE));
        goods.add(new Duster("Duster",
                "CrystalClean", "France", 30, 55, Quality.GOOD, Size.L,
                "cotton", "blue"));
        goods.add(new HighPressureWasher(
                "High Pressure Washer", "Karcher", "Germany", 3, 
                5000, Quality.GOOD, 3));
        goods.add(new Detergent("Detergent",
                "Mr.Clean", "Poland", 30, 60, Quality.GOOD, 1.5, "panel"));
        
    }
    
    @Test
    public void testWriteToFile() throws FileNotFoundException, IOException {
        CarCleaningGoodsWriter.writeToFile(goods);
        File file = new File("out.csv");
        try (FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufReader = new BufferedReader(isr);) {
            String line = null;
            String lines = "";
            while ((line = bufReader.readLine()) != null) {
                lines += line + "\n";
            }
            lines = lines.substring(0, lines.length() - 1);
            System.out.println(lines);
            Assertions.assertEquals(
                    "name, producer, country, salesPerDay, price,"
                    + " quality\n"
                    + "Brusher, Rock, Germany, 40, 45.0, BAD\n"
                    + "name, producer, country, salesPerDay, price,"
                    + " quality, stiffness, convienience\n"
                    + "Brusher, Rock, Poland, 10, 30.0, BAD, light,"
                    + " COMFORTABLE\n"
                    + "name, producer, country, salesPerDay, price, "
                    + "quality, size, material, color\n"
                    + "Duster, CrystalClean, France, 30, 55.0, GOOD,"
                    + " L, cotton, blue\n"
                    + "name, producer, country, salesPerDay, price,"
                    + " quality, power\n"
                    + "High Pressure Washer, Karcher, Germany, 3,"
                    + " 5000.0, GOOD, 3\n"
                    + "name, producer, country, salesPerDay, price,"
                    + " quality, capacity, appliance\n"
                    + "Detergent, Mr.Clean, Poland, 30, 60.0, GOOD, 1.5, panel",
                    lines);
          } finally {
            System.out.println();
        }
    }
    
}
