package org.example.seminars.sixth.hw;

import java.util.List;

public class ListAverageComparator<T extends Number> {

    // Метод, который приводит среднее значение к заданной точности
    public double roundToPrecision(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    // Метод, который сравнивает средние значения списков с заданной точностью
    public String compareAveragesWithPrecision(List<T> list1, List<T> list2, int decimalPlaces) {


        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        average1 = roundToPrecision(average1, decimalPlaces);
        average2 = roundToPrecision(average2, decimalPlaces);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average2 > average1) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }

    public double calculateAverage(List<T> list) {

        double sum = 0.0;
        for (T number : list) {
            sum += number.doubleValue();
        }
        return sum / list.size();
    }
}
