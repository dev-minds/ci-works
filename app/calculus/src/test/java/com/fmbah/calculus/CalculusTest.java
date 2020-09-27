package com.fmbah.calculus;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculusTest {
     private Calculus calculus = new Calculus();

     @Test
     public void testSum() {
          assertEquals(5, calculus.sum(2, 3));
     }
}