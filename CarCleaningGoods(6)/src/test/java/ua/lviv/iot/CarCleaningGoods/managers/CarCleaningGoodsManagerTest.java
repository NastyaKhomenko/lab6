package ua.lviv.iot.CarCleaningGoods.managers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;
import ua.lviv.iot.CarCleaningGoods.models.Quality;
import ua.lviv.iot.CarCleaningGoods.models.Size;
import ua.lviv.iot.CarCleaningGoods.models.Brusher;
import ua.lviv.iot.CarCleaningGoods.models.Duster;
import ua.lviv.iot.CarCleaningGoods.models.Convenience;
import ua.lviv.iot.CarCleaningGoods.models.HighPressureWasher;
import ua.lviv.iot.CarCleaningGoods.models.Detergent;


public class CarCleaningGoodsManagerTest {
    
    private List<CarCleaningGoods> goods;
    
    private CarCleaningGoodsManagerImpl carCleaningGoodsManager; 
    
    public void setUp() {
        goods = new ArrayList<>();
    }
    
    @BeforeEach 
    public void beforeEach() {
        goods = new ArrayList<>();
        carCleaningGoodsManager = new CarCleaningGoodsManagerImpl();
        carCleaningGoodsManager.addCarCleaningGoods(new CarCleaningGoods(
                "Brusher", "Rock", "Germany", 40, 45, Quality.BAD));
        carCleaningGoodsManager.addCarCleaningGoods(new Brusher("Brusher", 
                "Rock", "Poland", 10, 30, Quality.BAD, "light",
                Convenience.COMFORTABLE));
        carCleaningGoodsManager.addCarCleaningGoods(new Duster("Duster",
                "CrystalClean", "France", 30, 55, Quality.GOOD, Size.L,
                "cotton", "blue"));
        carCleaningGoodsManager.addCarCleaningGoods(new HighPressureWasher(
                "High Pressure Washer", "Karcher", "Germany", 3, 
                5000, Quality.GOOD, 3));
        carCleaningGoodsManager.addCarCleaningGoods(new Detergent("Detergent",
                "Mr.Clean", "Poland", 30, 60, Quality.GOOD, 1.5, "panel"));
        goods.addAll(carCleaningGoodsManager.getGoods());
        

    }

    @Test
    public void testfindByQualityMoreThan() {
     Assertions.assertEquals(0,
             carCleaningGoodsManager.findByQualityMoreThan(
                     Quality.MEDIUM).size());
     Assertions.assertEquals(2,
             carCleaningGoodsManager.findByQualityMoreThan(Quality.BAD).size());
    }

    @Test
    public void testFindByName() {
        Assertions.assertEquals(1,
                carCleaningGoodsManager.findByName("Detergent").size());
        Assertions.assertEquals(2,
                carCleaningGoodsManager.findByName("Brusher").size());
    }
    
    @Test
    public void testFindByProducer() {
        Assertions.assertEquals(0,
                carCleaningGoodsManager.findByProducer("Mr.Proper").size());
        Assertions.assertEquals(2,
                carCleaningGoodsManager.findByProducer("Rock").size());
    }
    
    @Test
    public void testFindByCountry() {
        Assertions.assertEquals(1, 
                carCleaningGoodsManager.findByCountry("France").size());
        Assertions.assertEquals(2, 
                carCleaningGoodsManager.findByCountry("Germany").size());
    }
    
    
    @Test
    void testSortByPriceDescending() {
        CarCleaningGoodsManagerImpl.sortByPriceDescending(goods);
        Assertions.assertEquals(60,  goods.get(1).getPrice());
        Assertions.assertEquals(60,  goods.get(1).getPrice());
    
    }
   
    @Test
    void testSortByPriceAscending() {
        CarCleaningGoodsManagerImpl.sortByPriceAscending(goods);
        Assertions.assertEquals(45,  goods.get(1).getPrice());
        Assertions.assertEquals(30,  goods.get(0).getPrice());
    
    }
   
    @Test
    void testSortBySalesPerDayDescending() {
        CarCleaningGoodsManagerImpl.sortBySalesPerDayDescending(goods);
        Assertions.assertEquals(30,  goods.get(1).getSalesPerDay());
        Assertions.assertEquals(40,  goods.get(0).getSalesPerDay());
    
    }
   
    @Test
    void testSortBySalesPerDayAscending() {
        CarCleaningGoodsManagerImpl.sortBySalesPerDayAscending(goods);
        Assertions.assertEquals(10,  goods.get(1).getSalesPerDay());
        Assertions.assertEquals(3,  goods.get(0).getSalesPerDay());
    
    } 
}
