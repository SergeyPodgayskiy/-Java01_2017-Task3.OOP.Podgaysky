package com.epam.task3.command.impl.general;

import com.epam.task3.bean.Candy;
import com.epam.task3.command.Command;
import com.epam.task3.parser.domparser.DOMGiftParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public class FindBySugarAmountCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(FindBySugarAmountCommand.class);

    @Override
    public ArrayList<Candy> execute(String request) {
        DOMGiftParser domGiftParser = new DOMGiftParser();
        ArrayList<Candy> gift = null;
        ArrayList<Candy> selectedCandies = null;
        try {
            domGiftParser.parseFile();
            gift = domGiftParser.getGift();
            String[] fullRequest = request.split(" ");
            double low = Double.parseDouble(fullRequest[0].trim());
            double high = Double.parseDouble(fullRequest[1].trim());
            if (isValidParams(fullRequest, low, high)) {
                selectedCandies = new ArrayList<>();
                for (Candy candy : gift) {
                    if (candy.getSugar() >= low && candy.getSugar() <= high) {
                        selectedCandies.add(candy);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedCandies;
    }

    private boolean isValidParams(String[] request, double low, double high) {
        if ((request.length == 2) && (high != 0.0) && (high >= low)) {
            return true;
        } else {
            LOGGER.error("Wrong number/format of parameters");
            return false;
        }
    }
}
