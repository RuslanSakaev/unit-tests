package seminars.sixth;

import org.example.seminars.sixth.hw.ListAverageComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListAverageComparatorTest {
    private ListAverageComparator<Number> listAverageComparator;

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

        assertThrows(NullPointerException.class, () -> {
            listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);
        });
    }
}
