package com.epam.task3.main;

import com.epam.task3.bean.Candy;
import com.epam.task3.bean.entity.Gift;
import com.epam.task3.comparator.candy.CarbohydrComparator;
import com.epam.task3.logic.Action;

import java.util.ArrayList;

/**
 * Created by serge on 31.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Action action = new Action();
        ArrayList<Candy> filteredCandies;
        Gift gift = action.collectGift();

        action.printGiftWeight(gift);
        action.printGiftContent(gift);
        System.out.println("------------------");
        filteredCandies = action.filterBySugarAmount(gift, 5, 7);
        action.printFilteredCandies(filteredCandies);
        System.out.println("-------------");
        action.sortByParameter(gift, new CarbohydrComparator());
        action.printGiftContent(gift);
    }
}
