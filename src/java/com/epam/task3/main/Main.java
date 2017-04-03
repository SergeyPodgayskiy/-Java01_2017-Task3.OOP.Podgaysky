package com.epam.task3.main;

import com.epam.task3.bean.manager.Confectioner;

/**
 * Created by serge on 31.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Confectioner confectioner = new Confectioner();
       confectioner.collectGift();
        confectioner.printGiftContent();
        confectioner.printGiftWeight();
        confectioner.findBySugarAmount(5,7);
       System.out.println("---------------");
        confectioner.sortByParameter("sugar");
        confectioner.printGiftContent();

    }
}
