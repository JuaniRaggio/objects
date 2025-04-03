package Ej4;

public class A {
  protected static final String MESSAGE = "Clase %s: Imprime %s %s que es de tipo %s";

  public void print(Object obj) {
    System.out.println(MESSAGE.formatted("A","Object",obj,obj.getClass()));
  }

  public void print(Number num) {
    System.out.println(MESSAGE.formatted("A","Number",num,num.getClass()));
  }

  public void print(Integer num) {
    System.out.println(MESSAGE.formatted("A","Integer",num,num.getClass()));
  }
}
