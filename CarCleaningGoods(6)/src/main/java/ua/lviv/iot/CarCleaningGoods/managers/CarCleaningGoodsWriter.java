package ua.lviv.iot.CarCleaningGoods.managers;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;

public class CarCleaningGoodsWriter {
    public static void writeToFile(final List<CarCleaningGoods> goods) 
        throws FileNotFoundException, IOException {

            File file = new File("out.csv");

            try (FileOutputStream fos = new FileOutputStream(file);

                OutputStreamWriter osw = new OutputStreamWriter(fos);

                BufferedWriter bufWriter = new BufferedWriter(osw);) {

              for (CarCleaningGoods carCleaningGoods:goods) {

                bufWriter.write(

                    carCleaningGoods.getHeaders() + "\n"

                            + carCleaningGoods.toCSV() + "\n"
                );
              }
            } finally {
              System.out.println();
            }
    }

    }

