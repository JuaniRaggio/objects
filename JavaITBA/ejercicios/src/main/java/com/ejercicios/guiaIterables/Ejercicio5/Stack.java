package com.ejercicios.guiaIterables.Ejercicio5;

public interface Stack<E> {

  // Pushes the element on top of the stack
  void push(E element);

  // Returns the element at the top of the stack
  E peek();

  // Returns and removes the element at the top of the stack
  E pop();

  // True if empty stack
  boolean isEmpty();
  
}
