#!/usr/bin/env ruby

# Es rara esta implementacion porque todos los metodos estan en array
# entonces medio que no tengo que hacer nada
class Stack
  def initialize
    @stack = Array.new
  end

  def push(elem) = @stack.push(elem)

  def peek = @stack.last

  def pop = @stack.pop

  def empty? = @stack.empty?
end

class AccessStack < Stack
  def initialize
    super
    @push_accesses = 0
    @pop_accesses = 0
  end

  def push(elem)
    @push_accesses += 1
    super(elem)
  end

  def pop
    @pop_accesses += 1
    super
  end

  attr_reader :pop_accesses, :push_accesses
end

stack = Stack.new
stack.push(2)
stack.push(3)
puts stack.peek # 3
puts stack.pop # 3
puts stack.empty? # false
puts stack.pop # 2
puts stack.empty? # true
puts stack.pop # Stack is empty (RuntimeError)

stack = AccessStack.new
stack.push(2)
stack.push(3)
stack.push(2)
puts stack.peek # 2
puts stack.pop # 2
puts stack.empty? # false
puts stack.pop # 3
puts stack.push_accesses # 3
puts stack.pop_accesses # 2
