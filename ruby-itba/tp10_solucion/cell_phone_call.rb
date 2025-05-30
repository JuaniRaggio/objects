#!/usr/bin/env ruby
class Call
 COST_PER_SECOND = 0.01

 def initialize(from, to, duration)
   @from = from
   @to = to
   @duration = duration
 end

 def cost
   @duration * COST_PER_SECOND
 end
end

class CellPhoneBill
 def initialize(number)
   @number = number
   @calls = []
 end

 def register_call(to_number, duration)
   @calls.push(Call.new(@number, to_number, duration))
 end

 def process_bill
   @calls.map{ |c| c.cost }.reduce(:+)
 end
end
