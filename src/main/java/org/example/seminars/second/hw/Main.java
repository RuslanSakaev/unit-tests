package org.example.seminars.second.hw;

public class Main {

    /*
     Домашнее задание к семинару №2 JUnit:
     1. Настроить новый проект:
         a). Нужно создать новый проект, со следующей структурой классов (3 отдельных класса):



         b). Настроить тестовую среду
             (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
             импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
         c). Написать следующие тесты:
             - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
             - проверка того, объект Car создается с 4-мя колесами
             - проверка того, объект Motorcycle создается с 2-мя колесами
             - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
             - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
             - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
             - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    */
    public static void main(String[] args) {
        // Создание объекта Car
        Car car = new Car("Honda", "Civic", 2012);
        System.out.println("Car Details:");
        System.out.println("Company: " + car.getCompany());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year of Release: " + car.getYearRelease());
        System.out.println("Number of Wheels: " + car.getNumWheels());

        // Тестовое вождение
        car.testDrive();
        System.out.println("Car Speed after Test Drive: " + car.getSpeed());

        // Парковка
        car.park();
        System.out.println("Car Speed after Parking: " + car.getSpeed());

        // Создание объекта Motorcycle
        Motorcycle motorcycle = new Motorcycle("Yamaha", "Bolt", 2017);
        System.out.println("\nMotorcycle Details:");
        System.out.println("Company: " + motorcycle.getCompany());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year of Release: " + motorcycle.getYearRelease());
        System.out.println("Number of Wheels: " + motorcycle.getNumWheels());

        // Тестовое вождение
        motorcycle.testDrive();
        System.out.println("Motorcycle Speed after Test Drive: " + motorcycle.getSpeed());

        // Парковка
        motorcycle.park();
        System.out.println("Motorcycle Speed after Parking: " + motorcycle.getSpeed());
    }

}