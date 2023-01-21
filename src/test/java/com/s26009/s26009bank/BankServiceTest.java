package com.s26009.s26009bank;

import com.s26009.s26009bank.model.BankAccount;
import com.s26009.s26009bank.model.Transaction;
import com.s26009.s26009bank.storage.BankAccountStorage;
import com.s26009.s26009bank.storage.TransactionStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankServiceTest {

   private BankService bankService;

    @BeforeEach
    void setup() {
        BankAccountStorage bankAccountStorage = new BankAccountStorage();
        TransactionStorage transactionStorage = new TransactionStorage();
        bankService = new BankService(bankAccountStorage, transactionStorage);
    }

    @Test
    void shouldSuccessfullyCreateNewBankAccount_whenAddNewBankAccount_givenUnusedAccountId() {
        //given
        String accId = "hleb";

        //when
        boolean result = bankService.registerNewBankAccount(accId, 500);

        //then
        assertTrue(result);
    }

    @Test
    void shouldFailCreatingNewBankAccount_whenAddNewBankAccount_givenUsedAccountId() {
        //given
        String accId = "user1";

        //when
        boolean result = bankService.registerNewBankAccount(accId, 500);

        //then
        assertFalse(result);
    }

    @Test
    void shouldSuccessfullyCreateNewAcceptedTransaction_whenMakeNewTransaction_givenAmountLessThanSaldo() {
        //given
        String accId = "user1";
        Transaction expectedTransaction = new Transaction(new BankAccount(accId, 10000), 500);

        //when
        Transaction result = bankService.makeNewTransaction(accId, 500);

        //then
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedTransaction);
    }

    @Test
    void shouldSuccessfullyCreateNewDeclinedTransaction_whenMakeNewTransaction_givenAmountGreaterThanSaldo() {
        //given
        String accId = "user1";
        Transaction expectedTransaction = new Transaction(new BankAccount(accId, 10000), 50000);

        //when
        Transaction result = bankService.makeNewTransaction(accId, 50000);

        //then
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedTransaction);
    }

    @Test
    void shouldFailCreatingNewTransaction_whenMakeNewTransaction_givenNonexistentAccountId() {
        //given
        String accId = "asdf";

        //when
        Transaction result = bankService.makeNewTransaction(accId, 5000);

        //then
        assertThat(result).isNull();
    }
}