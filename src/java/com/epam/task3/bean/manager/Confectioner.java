package com.epam.task3.bean.manager;

import com.epam.task3.bean.Candy;
import com.epam.task3.controller.Controller;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by serge on 31.03.2017.
 */
public class Confectioner implements CandyOperation {//TODO Переименовать класс и вынести в пакет логики
    private static final Logger LOGGER = Logger.getLogger(Confectioner.class);
    private String name; // TODO Убарть эти поля
    private String surname;
    private short age;
    private Controller controller; //TODO Не должно быть так
    private ArrayList<Candy> gift; //TODO Создать класс гифт

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
    public ArrayList<Candy> findBySugarAmount(double low, double high) { //TODO Убрать комманды, сделать обычный один класс логики
        ArrayList<Candy> selectedCandies = null;
        if (isGiftCollected()) {
            selectedCandies =  controller.executeCommand("find_candy_by_amount_of_sugar " + low + " " + high);
        }
        return selectedCandies;
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
