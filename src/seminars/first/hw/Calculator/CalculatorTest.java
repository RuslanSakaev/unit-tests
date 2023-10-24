package seminars.first.hw.Calculator;

import org.assertj.core.api.Assertions;

public class CalculatorTest {
    public static void main(String[] args) {
        testCalculatingDiscountWithValidArguments();
        testCalculatingDiscountWithNegativePurchaseAmount();
        testCalculatingDiscountWithNegativeDiscountAmount();
        testCalculatingDiscountWithOutOfRangeDiscountAmount();
        testCalculatingDiscountWithMaxDiscount();
    }

    public static void testCalculatingDiscountWithValidArguments() {
        double purchaseAmount = 100.0;
        int discountAmount = 10; // 10% скидка
        double expectedDiscountedAmount = 90.0; // Ожидаемый результат

        double discountedAmount = Calculator.calculatingDiscount(purchaseAmount, discountAmount);

        // Проверяем, что результат соответствует ожидаемому результату
        Assertions.assertThat(discountedAmount).isEqualTo(expectedDiscountedAmount);
    }

    public static void testCalculatingDiscountWithNegativePurchaseAmount() {
        double purchaseAmount = -100.0;
        int discountAmount = 10;

        // Проверяем, что метод выбрасывает исключение IllegalArgumentException
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверный ввод: сумма покупки и сумма скидки должны быть " +
                        "неотрицательными, а сумма скидки должна находиться в диапазоне от 0 до 100");
    }

    public static void testCalculatingDiscountWithNegativeDiscountAmount() {
        double purchaseAmount = 100.0;
        int discountAmount = -10;

        // Проверяем, что метод выбрасывает исключение IllegalArgumentException
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверный ввод: сумма покупки и сумма скидки должны быть " +
                        "неотрицательными, а сумма скидки должна находиться в диапазоне от 0 до 100");
    }

    public static void testCalculatingDiscountWithOutOfRangeDiscountAmount() {
        double purchaseAmount = 100.0;
        int discountAmount = 110; // Процент скидки вне допустимого диапазона

        // Проверяем, что метод выбрасывает исключение IllegalArgumentException
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверный ввод: сумма покупки и сумма скидки должны быть " +
                        "неотрицательными, а сумма скидки должна находиться в диапазоне от 0 до 100");
    }


    public static void testCalculatingDiscountWithMaxDiscount() {
        double purchaseAmount = 100.0;
        int discountAmount = 100; // 100% скидка

        // Проверяем, что метод выбрасывает ArithmeticException
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка 100% не допустима");
    }
}