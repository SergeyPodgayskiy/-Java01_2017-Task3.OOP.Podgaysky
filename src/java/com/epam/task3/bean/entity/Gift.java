package com.epam.task3.bean.entity;

import com.epam.task3.bean.Candy;

import java.util.ArrayList;

/**
 * @author serge
 *         04.04.2017.
 */
public class Gift {
    private ArrayList<Candy> gift;

    public Gift() {
    }

    public ArrayList<Candy> getGift() {
        return gift;
    }

    public void setGift(ArrayList<Candy> gift) {
        this.gift = gift;
    }

    //TODO EQUALS toString
}
