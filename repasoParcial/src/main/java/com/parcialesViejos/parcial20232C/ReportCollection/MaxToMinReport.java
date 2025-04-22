package com.parcialesViejos.parcial20232C.ReportCollection;

import java.util.Comparator;

public class MaxToMinReport<R> extends MinToMaxReport<R> {

  public MaxToMinReport(Comparator<? super R> cmp) {
    super(cmp.reversed());
  }
  
}
