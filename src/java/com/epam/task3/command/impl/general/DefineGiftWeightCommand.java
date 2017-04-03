package com.epam.task3.command.impl.general;

import com.epam.task3.bean.Candy;
import com.epam.task3.command.Command;
import com.epam.task3.parser.domparser.DOMGiftParser;

import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public class DefineGiftWeightCommand implements Command {
    @Override
    public Double execute(String request) {
        DOMGiftParser domGiftParser = new DOMGiftParser();
        ArrayList<Candy> gift = null;
        double weight = 0.0;
        try {
            domGiftParser.parseFile();
            gift = domGiftParser.getGift();
            for (Candy candy : gift) {
                weight += candy.getWeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weight;
    }
}
