package com.epam.task3.bean.manager;

import com.epam.task3.bean.Candy;

import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public interface CandyOperation { // TODO: Название в единственном числе, вынести этот интерфейс в пакет логики
    void collectGift();
    double defineGiftWeight();
    ArrayList<Candy> findBySugarAmount(double low, double high);
    void sortByParameter(String param);
    void printGiftContent();
    void printGiftWeight();
}
