package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class S26009BankApplication {

//    public S26009BankApplication(CarService carService) {
//
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "9876",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 22)
//        );
//        System.out.println(testRental);
//    }

    public static void main(String[] args) {
        SpringApplication.run(S26009BankApplication.class, args);
    }

}
