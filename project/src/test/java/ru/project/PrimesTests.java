package ru.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

  @Test
  public void primeTest() {

    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void primeTestLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
  @Test
  public void nonPrimeTest() {

    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }
  @Test
  public void primeTestFast() {

    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }


}
