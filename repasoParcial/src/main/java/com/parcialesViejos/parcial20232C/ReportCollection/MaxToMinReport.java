package com.parcialesViejos.parcial20232C.ReportCollection;

import java.util.Comparator;

public class MaxToMinReport<? super R> extends MinToMaxReport<R> {

  public MaxToMinReport(Comparator<R> cmp) {
    super(cmp.reversed());
  }
  
}
