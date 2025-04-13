package com.ejercicios.guiaIterables.Ejercicio5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

  private Object[] m_Elements;
  private int m_SavedElements;
  private static final int s_INITIALDIM = 10;

  private void resize() {
    m_Elements = Arrays.copyOf(m_Elements, m_SavedElements + s_INITIALDIM);
  }

  public ArrayStack() {
    m_Elements = new Object[s_INITIALDIM];
  }

  // Pushes the element on top of the stack
  public void push(E element) {
    if (m_SavedElements == m_Elements.length) {
      resize();
    }
    m_Elements[m_SavedElements++] = element;
  }

  // Returns the element at the top of the stack
  @SuppressWarnings("unchecked")
  public E peek() {
    if (isEmpty())
      throw new EmptyStackException();
    return (E) m_Elements[m_SavedElements - 1];
  }

  // Returns and removes the element at the top of the stack
  public E pop() {
    E returnType = peek();
    --m_SavedElements;
    return returnType;
  }

  // True if empty stack
  public boolean isEmpty() {
    return m_SavedElements == 0;
  }

  @SuppressWarnings("unchecked")
  public String toString() {
    StringBuilder strBldr = new StringBuilder();
    strBldr.append("[");
    for (int i = m_SavedElements - 1; i > 0; --i) {
      strBldr.append((E) m_Elements[i]);
    }
    strBldr.append(", %s]".formatted(((E) m_Elements[0]).toString()));
    return strBldr.toString();
  }

}
