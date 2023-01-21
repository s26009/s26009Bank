package com.s26009.s26009bank;

import com.s26009.s26009bank.model.Car;
import com.s26009.s26009bank.model.CarType;
import com.s26009.s26009bank.model.RentalInfo;
import com.s26009.s26009bank.model.User;
import com.s26009.s26009bank.storage.CarStorage;
import com.s26009.s26009bank.storage.RentalStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarServiceIntegrationTest {

    @MockBean
    private CarStorage carStorage;

    @MockBean
    private RentalStorage rentalStorage;

    @Autowired
    private CarService carService;

    @Test
    void successPremiumCarRent() {
        //given
        Car car = new Car("", "", "", CarType.PREMIUM);
        when(carStorage.findCarByVin(any())).thenReturn(Optional.of(car));
        when(rentalStorage.isCarRented(any())).thenReturn(false);
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "4321",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental.getPrice()).isEqualTo(450);
    }

    @Test
    void successStandardCarRent() {
        //given
        Car car = new Car("", "", "", CarType.STANDARD);
        when(carStorage.findCarByVin(any())).thenReturn(Optional.of(car));
        when(rentalStorage.isCarRented(any())).thenReturn(false);
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "4321",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental.getPrice()).isEqualTo(300);
    }

    @Test
    void carDoesntExistInDataBase() {
        //given
        when(carStorage.findCarByVin(any())).thenReturn(Optional.empty());
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "randomVin",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental).isNull();
    }

    @Test
    void carIsCurrentlyRented() {
        //given
        when(carStorage.findCarByVin(any())).thenReturn(Optional.of(
                new Car("", "", "", CarType.PREMIUM)));
        when(rentalStorage.isCarRented(any())).thenReturn(true);
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "1234",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental).isNull();
    }

    @Test
    void givenEndDateIsBeforeStartDate() {
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "9876",
                LocalDate.of(2022, 11, 24),
                LocalDate.of(2022, 11, 23)
        );
        //then
        assertThat(testRental).isNull();
    }


}
