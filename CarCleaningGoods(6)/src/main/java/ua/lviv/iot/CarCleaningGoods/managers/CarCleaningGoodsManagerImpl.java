/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.lviv.iot.CarCleaningGoods.managers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.CarCleaningGoods.models.CarCleaningGoods;
import ua.lviv.iot.CarCleaningGoods.models.Quality;

public class CarCleaningGoodsManagerImpl implements Manager {
    private List<CarCleaningGoods> goods = new LinkedList<>();

    public CarCleaningGoodsManagerImpl() {
    }

    public CarCleaningGoodsManagerImpl(final List<CarCleaningGoods> goods) {
        this.goods = goods;
    }

    @Override
    public void addCarCleaningGoods(final CarCleaningGoods carCleaningGoods) {
        goods.add(carCleaningGoods);
    }

    interface SearchableCriteria<T> {
        boolean matchCriteria(T criterias);
    }

    public List<CarCleaningGoods> findCarCleaningGoodsByCriteria(
            final SearchableCriteria<CarCleaningGoods> criteria) {
        return goods.stream().filter(
                carCleaningGoods -> criteria.matchCriteria(carCleaningGoods))
                .collect(Collectors.toList());
    }

    public static void sortByPriceDescending(
            final List<CarCleaningGoods> goods) {

        Collections.sort(goods, Comparator.comparing(
                CarCleaningGoods::getPrice).reversed());
    }

    public static void sortByPriceAscending(
            final List<CarCleaningGoods> goods) {
        Collections.sort(goods, Comparator.comparingDouble(
                CarCleaningGoods::getPrice));
    }

    public static void sortBySalesPerDayDescending(
            final List<CarCleaningGoods> goods) {

        Collections.sort(goods, Comparator.comparing(
                CarCleaningGoods::getSalesPerDay).reversed());
    }

    public static void sortBySalesPerDayAscending(
            final List<CarCleaningGoods> goods) {
        Collections.sort(goods, Comparator.comparingDouble(
                CarCleaningGoods::getSalesPerDay));
    }

    public List<CarCleaningGoods> findByName(final String name) {

        return findCarCleaningGoodsByCriteria(
                criteria -> criteria.getName().compareTo(name) == 0);

    }

    public List<CarCleaningGoods> findByQualityMoreThan(final Quality quality) {

        return findCarCleaningGoodsByCriteria(
                criteria -> criteria.getQuality().compareTo(quality) == 0);

    }

    public List<CarCleaningGoods> findByProducer(final String producer) {

        return findCarCleaningGoodsByCriteria(
                criteria -> criteria.getProducer().compareTo(producer) == 0);

    }

    public List<CarCleaningGoods> findByCountry(final String country) {

        return findCarCleaningGoodsByCriteria(
                criteria -> criteria.getCountry().compareTo(country) == 0);
    }

    public List<CarCleaningGoods> getGoods() {
        return goods;
    }

    public void setGoods(final List<CarCleaningGoods> goods) {
        this.goods = goods;
    }

}
