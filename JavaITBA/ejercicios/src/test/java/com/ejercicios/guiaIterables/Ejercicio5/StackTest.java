package com.ejercicios.guiaIterables.Ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class StackTest {

  @Test
  public void main() {
    Stack<Integer> stack = new ArrayStack<>();
    stack.push(2);
    stack.push(3);
    assertEquals("[3, 2]", stack.toString());
    assertEquals(3, stack.peek());
    assertEquals(3, stack.pop());
    assertEquals(false, stack.isEmpty());
    assertEquals(2, stack.pop());
    assertEquals(true, stack.isEmpty());
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

}
