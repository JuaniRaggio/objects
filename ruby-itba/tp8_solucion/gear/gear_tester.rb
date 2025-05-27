require_relative 'gear'
require_relative 'wheel'

puts Gear.new(52, 11, Wheel.new(26, 1.5)).gear_inches # => 137.0909090909091
puts Gear.new(52, 11).ratio # => 4.7272727272727275

# chainring = 52
# cog = 11
# ratio = chainring / cog.to_f
# puts ratio # => 4.7272727272727275
# chainring = 30
# cog = 27
# ratio = chainring / cog.to_f
# puts ratio # => 1.1111111111111112
