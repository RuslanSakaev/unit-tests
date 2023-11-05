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
        list1.add(1.0f);
        list1.add(2);
        list1.add(3.0f);

        List<Number> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3.0f);
        list2.add(4);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_FloatAndDouble() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1.5f);
        list1.add(2.5);
        list1.add(3.5f);

        List<Number> list2 = new ArrayList<>();
        list2.add(2.5);
        list2.add(3.5f);
        list2.add(4.5);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_FloatAndNegative() {
        List<Number> list1 = new ArrayList<>();
        list1.add(-1.5f);
        list1.add(-2.5);
        list1.add(-3.5f);

        List<Number> list2 = new ArrayList<>();
        list2.add(-2.5);
        list2.add(-3.5f);
        list2.add(-4.5);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_DoubleAndNegative() {
        List<Number> list1 = new ArrayList<>();
        list1.add(-1.5);
        list1.add(-2.5);
        list1.add(-3.5);

        List<Number> list2 = new ArrayList<>();
        list2.add(-2.5);
        list2.add(-3.5);
        list2.add(-4.5);

        int decimalPlaces = 1;
        String result = listAverageComparator.compareAveragesWithPrecision(list1, list2, decimalPlaces);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void testCompareAveragesWithPrecision_Integers() {
        List<Number> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
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
        list1.add(1.5);
        list1.add(2.5);
        list1.add(3.5);

        List<Number> list2 = new ArrayList<>();
        list2.add(2.5);
        list2.add(3.5);
        list2.add(4.5);

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
