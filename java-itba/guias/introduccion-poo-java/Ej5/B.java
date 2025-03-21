package Ej4;


public class B extends A {
  @Override
  public void print(Number num) {
    System.out.println(MESSAGE.formatted("B","Number",num,num.getClass()));
  }
}
