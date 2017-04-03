package com.epam.task3.comparator.candy;

import com.epam.task3.bean.Candy;

import java.util.Comparator;

/**
 * Created by serge on 02.04.2017.
 */
public class NameComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
