package com.parcialesViejos.parcial20232C.ReportCollection;

public interface ReportCollection <R> {

  void add(R report);

  R get(int index);

  R[] reports();

}
