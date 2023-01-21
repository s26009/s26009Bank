package com.s26009.s26009bank;

import com.s26009.s26009bank.model.Car;
import com.s26009.s26009bank.model.Rental;
import com.s26009.s26009bank.model.RentalInfo;
import com.s26009.s26009bank.model.User;
import com.s26009.s26009bank.storage.CarStorage;
import com.s26009.s26009bank.storage.RentalStorage;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    private static final int BASE_PRICE = 300;
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;
    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }
    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        double price;
        long numberOfDays = calculateNumberOfDays(startDate, endDate);
        Optional<Car> car = carStorage.findCarByVin(vin);
        if(car.isEmpty()) {
            System.out.println("Car with this vin doesn't exist in database");
            return null;
        }

        if (rentalStorage.isCarRented(vin)) {
            System.out.println("Car is currently rented");
            return null;
        }

        if (numberOfDays < 1) {
            System.out.println("Invalid time slot given");
            return null;
        }

        price = calculatePrice(car.get(), numberOfDays);
        rentalStorage.addNewRental(new Rental(user, car.get()));

        return new RentalInfo(price, startDate, endDate);
    }

    private long calculateNumberOfDays(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    private double calculatePrice(Car car, long numberOfDays) {
        return car.getCarType().getMultiplier() * BASE_PRICE * numberOfDays;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }
}
