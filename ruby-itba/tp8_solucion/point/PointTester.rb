require_relative 'Point'

my_point = Point.new(1.5, 2.5)
puts my_point # {1.5, 2.5}
puts my_point.distance(Point.new(1.5, 3.0)) # 0.5
