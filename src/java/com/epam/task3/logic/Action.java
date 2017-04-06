package com.epam.task3.logic;

import com.epam.task3.bean.Candy;
import com.epam.task3.bean.entity.Gift;
import com.epam.task3.parser.domparser.DOMGiftParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by serge on 31.03.2017.
 */
public class Action {
    private static final Logger LOGGER = Logger.getLogger(Action.class);

    public Action() {
    }

    public Gift collectGift() {
        DOMGiftParser domGiftParser = new DOMGiftParser();
        domGiftParser.parseFile();
        Gift gift = new Gift();
        gift.setGift(domGiftParser.getCandyArrayList());
        return gift;
    }

    public double defineGiftWeight(Gift gift) {
        double weight = 0.0;
        if (isGiftCollected(gift)) {
            for (Candy candy : gift.getGift()) {
                weight += candy.getWeight();
            }
            return weight;
        }
        return 0.0;
    }

    public ArrayList<Candy> filterBySugarAmount(Gift gift, double low, double high) {
        if (isGiftCollected(gift)) {
            ArrayList<Candy> filteredCandies = new ArrayList<>();
            for (Candy candy : gift.getGift()) {
                if (candy.getSugar() >= low && candy.getSugar() <= high) {
                    filteredCandies.add(candy);
                }
            }
            return filteredCandies;
        }
        return null;
    }

    public Gift sortByParameter(Gift gift, Comparator c) {
        gift.getGift().sort(c);
        return gift;
    }

    public void printGiftContent(Gift gift) {
        if (isGiftCollected(gift)) {
            for (Candy candy : gift.getGift()) {
                System.out.println(candy.toString());
            }
        }
    }

    public void printFilteredCandies(ArrayList<Candy> filteredCandies) {
        for (Candy candy : filteredCandies) {
            System.out.println(candy.toString());
        }
    }

    public void printGiftWeight(Gift gift) {
        System.out.println(defineGiftWeight(gift) + " грамм.");
    }

    private boolean isGiftCollected(Gift gift) {
        if (!gift.getGift().isEmpty()) {
            return true;
        } else {
            LOGGER.error("Gift is not collected");
            return false;
        }
    }
}
