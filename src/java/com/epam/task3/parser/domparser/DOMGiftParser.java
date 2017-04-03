package com.epam.task3.parser.domparser;

import com.epam.task3.bean.Candy;
import com.epam.task3.bean.entity.CaramelWithFilling;
import com.epam.task3.bean.entity.ChocoFillingCandy;
import com.epam.task3.bean.entity.ChocoNutsCandy;
import com.epam.task3.bean.entity.Lollipop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by serge on 01.04.2017.
 */
public class DOMGiftParser {
    private static final String XML_PATH = "src/resources/christmasGift.xml";
    private ArrayList<Candy> gift;
    private Candy candy;

    public void parseFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = document.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(XML_PATH));
        NodeList nodeList = doc.getElementsByTagName("candy");
        String type;
        gift = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            type = element.getElementsByTagName("type").item(0).getTextContent();
            if (type.equals("lollipop")) {
                candy = getLollipop(element);
                gift.add(candy);
            }
            if (type.equals("caramelWithFilling")) {
                candy = getCaramelWithFilling(element);
                gift.add(candy);
            }
            if (type.equals("chocoFillingCandy")) {
                candy = getChocoFillingCandy(element);
                gift.add(candy);
            }
            if (type.equals("chocoNutsCandy")) {
                candy = getChocoNutsCandy(element);
                gift.add(candy);
            }
        }
    }

    private Lollipop getLollipop(Element element) {
        Lollipop lollipop = new Lollipop();
        setGeneralFields(element, lollipop);
        lollipop.setWater(Integer.parseInt(element.
                getElementsByTagName("water").item(0).getTextContent()));
        lollipop.setFlavoring(element.
                getElementsByTagName("flavoring").item(0).getTextContent());
        lollipop.setColorant(element.
                getElementsByTagName("colorant").item(0).getTextContent());
        return lollipop;
    }

    private CaramelWithFilling getCaramelWithFilling(Element element) {
        CaramelWithFilling caramelWithFilling = new CaramelWithFilling();
        setGeneralFields(element, caramelWithFilling);
        caramelWithFilling.setWater(Integer.parseInt(element.
                getElementsByTagName("water").item(0).getTextContent()));
        caramelWithFilling.setFlavoring(element.
                getElementsByTagName("flavoring").item(0).getTextContent());
        caramelWithFilling.setFilling(element.
                getElementsByTagName("filling").item(0).getTextContent());
        return caramelWithFilling;
    }

    private ChocoFillingCandy getChocoFillingCandy(Element element) {
        ChocoFillingCandy chocoFillingCandy = new ChocoFillingCandy();
        setGeneralFields(element, chocoFillingCandy);
        chocoFillingCandy.setFilling(element.
                getElementsByTagName("filling").item(0).getTextContent());
        chocoFillingCandy.setCacao(Double.parseDouble(element.
                getElementsByTagName("cacao").item(0).getTextContent()));
        chocoFillingCandy.setMilkPowder(Double.parseDouble(element.
                getElementsByTagName("milkPowder").item(0).getTextContent()));
        return chocoFillingCandy;
    }

    private ChocoNutsCandy getChocoNutsCandy(Element element) {
        ChocoNutsCandy chocoNutsCandy = new ChocoNutsCandy();
        setGeneralFields(element, chocoNutsCandy);
        chocoNutsCandy.setAdditive(element.
                getElementsByTagName("additive").item(0).getTextContent());
        chocoNutsCandy.setCacao(Double.parseDouble(element.
                getElementsByTagName("cacao").item(0).getTextContent()));
        chocoNutsCandy.setMilkPowder(Double.parseDouble(element.
                getElementsByTagName("milkPowder").item(0).getTextContent()));
        return chocoNutsCandy;
    }

    private void setGeneralFields(Element element, Candy candy) {
        candy.setName(element.getElementsByTagName("name").
                item(0).getTextContent());
        candy.setWeight(Double.parseDouble(element.
                getElementsByTagName("weight").item(0).getTextContent()));
        candy.setCarbohydrates(Double.parseDouble(element.
                getElementsByTagName("carbohydrates").item(0).getTextContent()));
        candy.setFats(Double.parseDouble(element.
                getElementsByTagName("fats").item(0).getTextContent()));
        candy.setProteins(Double.parseDouble(element.
                getElementsByTagName("proteins").item(0).getTextContent()));
        candy.setKilocalories(Short.parseShort((element.
                getElementsByTagName("kilocalories").item(0).getTextContent())));
        candy.setSugar(Double.parseDouble(element.
                getElementsByTagName("sugar").item(0).getTextContent()));
    }

    public ArrayList<Candy> getGift() {
        return gift;
    }
}
