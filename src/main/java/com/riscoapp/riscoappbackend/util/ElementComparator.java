package com.riscoapp.riscoappbackend.util;

import com.riscoapp.riscoappbackend.datamodel.Element;

import java.util.Comparator;

public class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element a, Element b) {
        double ratioA = a.getCalories() / a.getWeight();
        double ratioB = b.getCalories() / b.getWeight();
        return Double.compare(ratioB, ratioA); // Orden descendente
    }
}
