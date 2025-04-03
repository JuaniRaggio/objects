package com.talleres.tallerComparable;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class PhoneNumberTest {

  @Test
  public void pnTest() {
    PhoneNumber[] pn = new PhoneNumber[3];
    pn[0] = new PhoneNumber(11, 549, 10000000);
    pn[1] = new PhoneNumber(11, 49, 10000000);
    pn[2] = new PhoneNumber(11, 54, 10000000);
    Arrays.sort(pn);
    // for (PhoneNumber p : pn)
    //   System.out.println(p);

    // Mejor forma:
    Comparator<PhoneNumber> comp = (a, b) -> (b.compareTo(a));
    Arrays.sort(pn, comp);
    // for (PhoneNumber p : pn)
    //   System.out.println(p);
  }

}
