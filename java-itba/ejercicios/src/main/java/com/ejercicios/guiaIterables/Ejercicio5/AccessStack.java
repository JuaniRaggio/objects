package com.ejercicios.guiaIterables.Ejercicio5;

public class AccessStack<E> extends ArrayStack<E> {

  private int m_PushCalls = 0, m_PopCalls = 0;

  public int getM_PopCalls() {
      return m_PopCalls;
  }

  public int getM_PushCalls() {
      return m_PushCalls;
  }

  @Override
  public E pop() {
    // This will increase m_PopCalls even if an exception is thrown
    ++m_PopCalls;
    return super.pop();
  }

  @Override
  public void push(E element) {
    // Idem pop()
    ++m_PushCalls;
    super.push(element);
  }

}
