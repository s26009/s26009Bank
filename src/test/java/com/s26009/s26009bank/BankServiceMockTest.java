package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import com.s26009.s26009bank.storage.BankAccountStorage;
import com.s26009.s26009bank.storage.TransactionStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceMockTest {

    @Mock
    private BankAccountStorage bankAccountStorage;

    @Mock
    private TransactionStorage transactionStorage;

    @InjectMocks
    private BankService bankService;

    @Test
    void shouldSuccessfullyCreateNewBankAccount_whenAddNewBankAccount_givenUnusedAccountId() {
        //given
        String accId = "hleb";
        Optional<BankAccount> bankAccountOptional = Optional.empty();
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        boolean result = bankService.registerNewBankAccount(accId, 500);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertTrue(result);
    }

    @Test
    void shouldFailCreatingNewBankAccount_whenAddNewBankAccount_givenUsedAccountId() {
        //given
        String accId = "user1";
        Optional<BankAccount> bankAccountOptional = Optional.of(new BankAccount("user1", 500));
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        boolean result = bankService.registerNewBankAccount(accId, 500);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertFalse(result);
    }

    @Test
    void shouldSuccessfullyCreateNewAcceptedTransaction_whenMakeNewTransaction_givenAmountLessThanSaldo() {
        //given
        String accId = "user1";
        BankAccount bankAccount = new BankAccount(accId, 10000);
        Optional<BankAccount> bankAccountOptional = Optional.of(bankAccount);
        Transaction expectedTransaction = new Transaction(bankAccount, 500);
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        Transaction result = bankService.makeNewTransaction(accId, 500);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedTransaction);
    }

    @Test
    void shouldSuccessfullyCreateNewDeclinedTransaction_whenMakeNewTransaction_givenAmountGreaterThanSaldo() {
        //given
        String accId = "user1";
        BankAccount bankAccount = new BankAccount(accId, 10000);
        Optional<BankAccount> bankAccountOptional = Optional.of(bankAccount);
        Transaction expectedTransaction = new Transaction(bankAccount, 50000);
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        Transaction result = bankService.makeNewTransaction(accId, 50000);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedTransaction);
    }

    @Test
    void shouldFailCreatingNewTransaction_whenMakeNewTransaction_givenNonexistentAccountId() {
        //given
        String accId = "nonexistent";
        Optional<BankAccount> bankAccountOptional = Optional.empty();
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        Transaction result = bankService.makeNewTransaction(accId, 5000);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnBankAccountInfo_whenGetBankAccountInfo_givenExistingAccountId() {
        //given
        String accId = "user1";
        BankAccount bankAccount = new BankAccount(accId, 10000);
        Optional<BankAccount> bankAccountOptional = Optional.of(bankAccount);
        BankAccount expectedBankAccount = new BankAccount(accId, 10000);
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        BankAccount result = bankService.getBankAccountInfo(accId);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedBankAccount);
    }

    @Test
    void shouldNotReturnBankAccountInfo_whenGetBankAccountInfo_givenNonexistentAccountId() {
        //given
        String accId = "nonexistent";
        BankAccount bankAccount = new BankAccount(accId, 10000);
        Optional<BankAccount> bankAccountOptional = Optional.of(bankAccount);
        BankAccount expectedBankAccount = new BankAccount(accId, 10000);
        when(bankAccountStorage.findBankAccountByAccId(any())).thenReturn(bankAccountOptional);

        //when
        BankAccount result = bankService.getBankAccountInfo(accId);

        //then
        verify(bankAccountStorage).findBankAccountByAccId(accId);
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedBankAccount);
    }
}