package com.example1;

import org.assertj.core.error.AssertionErrorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 01-04-2016.
 */
public class AccountTests {
    private String name;
    private double balance;
    private Account account;

    @Before
    public void setUp() throws Exception {
        this.name = "testName";
        this.balance = 1000.0;
        this.account = new Account(name, balance);

    }

    @Test
    public void withdrawShouldDeductAmountFromBalance() throws Exception {
        account.withdraw(400.0);
        Assert.assertEquals(600.0, account.getBalance(), 0.01);
    }

    @Test(expected = Exception.class)
    public void throwExceptionForDeductionInsufficientBalance() throws Exception {
        account.withdraw(400.0);
        Assert.assertEquals(600.0, account.getBalance(), 0.01);
    }


    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionForNegativeBalance() throws Exception {
        account.withdraw(-1100);
    }


}
