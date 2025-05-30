#!/usr/bin/env ruby

module Expression
 def evaluate
   raise 'Not implemented'
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
exp2.value = true
p exp5.evaluate # true
