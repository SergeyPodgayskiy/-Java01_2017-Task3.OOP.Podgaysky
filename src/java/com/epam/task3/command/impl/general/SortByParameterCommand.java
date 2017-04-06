package com.epam.task3.command.impl.general;

import com.epam.task3.bean.Candy;
import com.epam.task3.command.Command;
import com.epam.task3.comparator.candy.*;
import com.epam.task3.parser.domparser.DOMGiftParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public class SortByParameterCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(SortByParameterCommand.class);

    @Override
    public ArrayList<Candy> execute(String request) {
        DOMGiftParser domGiftParser = new DOMGiftParser();
        ArrayList<Candy> gift = null;

        try {
            domGiftParser.parseFile();
            gift = domGiftParser.getGift();
            String[] fullRequest = request.split(" ");
            if (isValidParams(fullRequest)) {
                String parameter = fullRequest[0];
                switch (parameter) {
                    case "weight":
                        gift.sort(new WeightComparator());
                        break;

                    case "name":
                        gift.sort(new NameComparator());
                        break;

                    case "fats":
                        gift.sort(new FatsComparator());
                        break;

                    case "kcal":
                        gift.sort(new KcalComparator());
                        break;

                    case "proteins":
                        gift.sort(new ProteinComparator());
                        break;

                    case "sugar":
                        gift.sort(new SugarComparator());
                        break;

                    case "carbohydrates":
                        gift.sort(new CarbohydrComparator());
                        break;

                    default:
                        System.err.println("Incorrect parameter of sorting");
                }
            }
            return gift;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isValidParams(String[] param) {
        if (param.length == 1) {
            return true;
        } else {
            LOGGER.error("Wrong number/format of parameters.");
            return false;
        }
    }
}
