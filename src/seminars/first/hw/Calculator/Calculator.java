package seminars.first.hw.Calculator;

public class Calculator {

//    Задание 1. ** В классе Calculator создайте метод calculateDiscount,
//    который принимает сумму покупки и процент скидки и возвращает сумму с
//    учетом скидки. Ваша задача - проверить этот метод с использованием библиотеки
//    AssertJ. Если метод calculateDiscount получает недопустимые аргументы,
//    он должен выбрасывать исключение ArithmeticException. Не забудьте написать
//    тесты для проверки этого поведения.

    // purchaseAmount - сумма покупки
    // discountAmount - размер скидки

    // Метод для вычисления суммы покупки со скидкой
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new IllegalArgumentException("Неверный ввод: сумма покупки и сумма скидки должны быть " +
                    "неотрицательными, а сумма скидки должна находиться в диапазоне от 0 до 100");
        }


        // Рассчитываем сумму со скидкой
        if (discountAmount == 100) {
            throw new ArithmeticException("Скидка 100% не допустима");
        }

        double discount = (double) discountAmount / 100.0;

        return purchaseAmount - (purchaseAmount * discount);

    }
}
