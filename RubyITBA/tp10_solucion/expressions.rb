#!/usr/bin/env ruby
module Expression
  def evaluate
    raise 'Not implemented'
  end

  def not
    Not.new(self)
  end

  def or(other_exp)
    Or.new(self, other_exp)
  end

  def and(other_exp)
    And.new(self, other_exp)
  end
end

class SimpleExpression
  include Expression

  attr_writer :value

  def initialize(value)
    @value = value
  end

  def evaluate
    @value
  end
end

class BinaryOperation
  include Expression
  def initialize(exp1, exp2)
    @left_exp = exp1
    @right_exp = exp2
  end

  protected

  attr_reader :left_exp, :right_exp
end

class And < BinaryOperation
  def evaluate
    @left_exp.evaluate && @right_exp.evaluate
  end
end

class Or < BinaryOperation
  def evaluate
    @left_exp.evaluate || @right_exp.evaluate
  end
end

class UnaryOperation
  include Expression
  def initialize(exp)
    @expression = exp
  end

  protected

  attr_reader :expression
end

class Not < UnaryOperation
  def evaluate
    !@expression.evaluate
  end
end

# Test
exp1 = SimpleExpression.new(true)
exp2 = SimpleExpression.new(false)
exp3 = exp1.not
exp4 = exp1.or(exp2)
exp5 = exp3.and(exp4)
p exp1.evaluate # true
p exp3.evaluate # false
p exp4.evaluate # true
p exp5.evaluate # false
exp1.value = false
p exp3.evaluate # true
p exp4.evaluate # false
p exp5.evaluate # false
p exp2.value = true
p exp5.evaluate # true
