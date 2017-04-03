package com.epam.task3.comparator.candy;

import com.epam.task3.bean.Candy;

import java.util.Comparator;

/**
 * Created by serge on 02.04.2017.
 */
public class ProteinComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        if (o1.getProteins() > o2.getProteins()) {
            return 1;
        } else if (o1.getProteins() < o2.getProteins()) {
            return -1;
        } else {
            return 0;
        }
    }
}
