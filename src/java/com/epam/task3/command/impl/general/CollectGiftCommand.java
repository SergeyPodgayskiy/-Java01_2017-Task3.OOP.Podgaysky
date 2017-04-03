package com.epam.task3.command.impl.general;

import com.epam.task3.bean.Candy;
import com.epam.task3.command.Command;
import com.epam.task3.parser.domparser.DOMGiftParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public class CollectGiftCommand implements Command {
    @Override
    public ArrayList<Candy> execute(String request) {
        DOMGiftParser domGiftParser = new DOMGiftParser();
        ArrayList<Candy> gift = null;
        try {
            domGiftParser.parseFile();
            gift = domGiftParser.getGift();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return gift;
    }
}
