package com.parcialesViejos.parcial20232C.ReportCollection;

import java.util.Arrays;
import java.util.Comparator;

public class MinToMaxReport<R> extends Reports<R> {

  private Comparator<R> desiredOrder;

  public MinToMaxReport(Comparator<R> cmp) {
    super();
    desiredOrder = cmp;
  }

  @Override
  public R[] reports() {
    R[] reports = Arrays.copyOf(super.reports(), super.getAddedElements());
    Arrays.sort(reports, desiredOrder);
    return reports;
  }

}
