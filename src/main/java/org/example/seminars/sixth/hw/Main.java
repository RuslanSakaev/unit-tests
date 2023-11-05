package org.example.seminars.sixth.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        ListAverageComparator<Number> comparator = new ListAverageComparator<>();

        List<Double> list1 = new ArrayList<>();
        list1.add(1.5); // Double
        list1.add(2.0444);
        list1.add(3.5);
        list1.add(6.5);

        List<Float> list2 = new ArrayList<>();
        list2.add(2.0f); // Float
        list2.add(2.0999f);
        list2.add(1.0f);
        list2.add(2.0f);
        list2.add(1.06544f);
        list2.add(8.06674f);
        list2.add(100.0f);

        int decimalPlaces = 2; // Задаем количество десятичных знаков для округления

        String result = comparator.compareAveragesWithPrecision(new ArrayList<>(list1), new ArrayList<>(list2), decimalPlaces);

        logger.info(result);
    }
}
