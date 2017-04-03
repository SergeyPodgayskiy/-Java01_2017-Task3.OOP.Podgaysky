package com.epam.task3.bean.manager;

import com.epam.task3.bean.Candy;
import com.epam.task3.controller.Controller;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by serge on 31.03.2017.
 */
public class Confectioner implements Serializable, CandyOperations {
    private static final Logger LOGGER = Logger.getLogger(Confectioner.class);
    private String name;
    private String surname;
    private short age;
    private Controller controller;
    private ArrayList<Candy> gift;

    public Confectioner() {
        controller = new Controller();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public void collectGift() {
        gift = controller.executeCommand("collect_gift");
    }

    @Override
    public double defineGiftWeight() {
        if (isGiftCollected()) {
            return controller.executeCommand("define_gifts_weight");
        } else {
            return 0.0;
        }
    }

    @Override
    public void findBySugarAmount(double low, double high) {
        if (isGiftCollected()) {
            ArrayList<Candy> selectedCandies =
                    controller.executeCommand("find_candy_by_amount_of_sugar " + low + " " + high);
            for (Candy candy : selectedCandies) {
                System.out.println(candy.toString());
            }
        }
    }

    @Override
    public void sortByParameter(String param) {
        if(isGiftCollected()){
           gift = controller.executeCommand("sort_by_parameter " + param);
        }
    }

    @Override
    public void printGiftContent() {
        if (isGiftCollected()) {
            for (Candy candy : gift) {
                System.out.println(candy.toString());
            }
        }
    }

    @Override
    public void printGiftWeight() {
        System.out.println(defineGiftWeight() + " грамм.");
    }

    private boolean isGiftCollected() {
        if (gift != null && !gift.isEmpty()) {
            return true;
        } else {
            LOGGER.error("Gift is not collected");
            return false;
        }
    }
}
