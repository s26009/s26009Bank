package com.s26009.s26009bank;

import com.s26009.s26009bank.storage.BankAccountStorage;
import com.s26009.s26009bank.storage.TransactionStorage;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

//    private CarService carService;
//
//    @BeforeEach
//    void setup() {
//        BankAccountStorage bankAccountStorage = new BankAccountStorage();
//        TransactionStorage transactionStorage = new TransactionStorage();
//        carService = new CarService(bankAccountStorage, transactionStorage);
//    }

//    @Test
//    void successCarRent() {
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "4321",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 24)
//        );
//        //then
//        assertThat(testRental).hasToString("Rental info: price: 300.0 start date: 2022-11-23 end date: 2022-11-24");
//    }
//
//    @Test
//    void carDosentExistinDataBase() {
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "randomVin",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 24)
//        );
//        //then
//        assertThat(testRental).isNull();
//    }
//
//    @Test
//    void carIsCurrentlyRented() {
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "1234",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 24)
//        );
//        //then
//        assertThat(testRental).isNull();
//    }
//
//    @Test
//    void premiumClassCarIsPricier() {
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "9876",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 24)
//        );
//        //then
//        assertThat(testRental).hasToString("Rental info: price: 450.0 start date: 2022-11-23 end date: 2022-11-24");
//    }
//
//    @Test
//    void givenEndDateIsBeforeStartDate() {
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "9876",
//                LocalDate.of(2022, 11, 24),
//                LocalDate.of(2022, 11, 23)
//        );
//        //then
//        assertThat(testRental).isNull();
//    }
}