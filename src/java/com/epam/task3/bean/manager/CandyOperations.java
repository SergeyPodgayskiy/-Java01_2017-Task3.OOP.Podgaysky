package com.epam.task3.bean.manager;

/**
 * Created by serge on 01.04.2017.
 */
public interface CandyOperations {
    void collectGift();
    double defineGiftWeight();
    void findBySugarAmount(double low, double high);
    void sortByParameter(String param);
    void printGiftContent();
    void printGiftWeight();
}
