package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import com.s26009.s26009bank.storage.BankAccountStorage;
import com.s26009.s26009bank.storage.TransactionStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceMockTest {

    @Captor
    private ArgumentCaptor<BankAccount> bankAccountArgumentCaptor;

    @Captor
    private ArgumentCaptor<Transaction> transactionArgumentCaptor;

    @Mock
    private BankAccountStorage bankAccountStorage;

    @Mock
    private TransactionStorage TransactionStorage;

    @InjectMocks
    private BankService bankService;

    @Test
    void shouldSuccessfullyCreateNewBankAccount_whenAddNewBankAccount_givenUnusedAccountId() {
        //given
        String accId = "hleb";
        Optional<BankAccount> bankAccountOptional = Optional.empty();
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        Optional<BankAccount> result = bankService.findBankAccountByAccId(accId);

        //then
        //verify(bankAccountStorage).findBankAccountByAccId(accId)
        //assertTrue(result);
    }
//
//    @Test
//    void successStandardCarRent() {
//        //given
//        Car car = new Car("", "", "", CarType.STANDARD);
//        when(carStorage.findCarByVin(any())).thenReturn(Optional.of(car));
//        when(rentalStorage.isCarRented(any())).thenReturn(false);
//        //when
//        RentalInfo testRental = carService.rentCar(
//                new BankAccount("1"), "4321",
//                LocalDate.of(2022, 11, 23),
//                LocalDate.of(2022, 11, 24)
//        );
//        //then
//        assertThat(testRental.getPrice()).isEqualTo(300);
//    }
//
//    @Test
//    void carDosentExistinDataBase() {
//        //given
//        when(carStorage.findCarByVin(any())).thenReturn(Optional.empty());
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
//        //given
//        when(carStorage.findCarByVin(any())).thenReturn(Optional.of(
//                new Car("", "", "", CarType.PREMIUM)));
//        when(rentalStorage.isCarRented(any())).thenReturn(true);
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