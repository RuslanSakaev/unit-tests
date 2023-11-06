package seminars.sixth;

import org.example.seminars.sixth.hw.ListAverageComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListAverageComparatorTest {
    private ListAverageComparator<Number> listAverageComparator = new ListAverageComparator<>();

    @BeforeEach
    void setUp() {
        listAverageComparator = new ListAverageComparator<>();
    }

    @Test
    void testCompareAveragesWithPrecision_FloatAndInteger() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1.063463f);
        list1.add(2.0665f);
        list1.add(3.00552f);
        list1.add(6.00008f);

        List<Number> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        list2.add(6);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_FloatAndDouble() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1.25047f);
        list1.add(2.25084f);
        list1.add(3.050874f);
        list1.add(0.50874f);
        list1.add(0.450874f);

        List<Number> list2 = new ArrayList<>();
        list2.add(1.2);
        list2.add(1.3);
        list2.add(2.1);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_FloatAndNegative() {
        List<Number> list1 = new ArrayList<>();
        list1.add(-1.5f);
        list1.add(-2.5f);
        list1.add(-3.5f);

        List<Number> list2 = new ArrayList<>();
        list2.add(-1.5);
        list2.add(-2.5);
        list2.add(-3.5);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_ExtremeValues() {
        List<Number> list1 = new ArrayList<>();
        list1.add(Double.MAX_VALUE); // Максимальное значение Double
        list1.add(Double.MIN_VALUE); // Минимальное положительное значение Double
        list1.add(Integer.MAX_VALUE); // Максимальное значение int

        List<Number> list2 = new ArrayList<>();
        list2.add(Float.MAX_VALUE); // Максимальное значение Float
        list2.add(-Float.MIN_VALUE); // Минимальное положительное значение Float
        list2.add(-Integer.MAX_VALUE); // Отрицательное значение int

        int decimalPlaces = 2147483647;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_Integers() {
        List<Number> list1 = new ArrayList<>();
        list1.add(8);
        list1.add(22);
        list1.add(3);

        List<Number> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void testCompareAveragesWithPrecision_EmptyLists() {
        List<Number> list1 = new ArrayList<>();
        List<Number> list2 = new ArrayList<>();

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_DifferentDecimalPlaces() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1.55);
        list1.add(2.55);
        list1.add(3.55);

        List<Number> list2 = new ArrayList<>();
        list2.add(2.5);
        list2.add(3.5);
        list2.add(1.5);

        int decimalPlaces = 2;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void testCompareAveragesWithPrecision_NullList() {
        List<Number> list1 = null;
        List<Number> list2 = new ArrayList<>();

        int decimalPlaces = 1;

        assertThrows(NullPointerException.class, () -> listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces));
    }

    @Test
    void testCompareAveragesWithPrecision_SecondListGreater() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);

        List<Number> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        int decimalPlaces = 2;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Второй список имеет большее среднее значение", result);
    }

    @Test
    void testCalculateAverage_Integers() {
        List<Number> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        double result = listAverageComparator.calculateAverage(integerList);
        assertEquals(1.5, result, 0.0001);
    }

    @Test
    void testCalculateAverage_Floats() {
        List<Number> floatList = new ArrayList<>();
        floatList.add(1.5f);
        floatList.add(2.5f);
        double result = listAverageComparator.calculateAverage(floatList);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    void testCalculateAverage_Negatives() {
        List<Number> negativeList = new ArrayList<>();
        negativeList.add(-1);
        negativeList.add(-2);
        double result = listAverageComparator.calculateAverage(negativeList);
        assertEquals(-1.5, result, 0.0001);
    }
}
