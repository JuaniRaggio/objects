require_relative 'rectangle'
require_relative 'triangle'
require_relative 'ellipse'
require_relative 'circle'

start_point = Point.new(0, 0)
my_rectangle = Rectangle.new(start_point, Point.new(2, 4))
puts my_rectangle
puts my_rectangle.perimeter
puts my_rectangle.area

my_triangle = Triangle.new(start_point, Point.new(1, 0), Point.new(0, 1))
puts my_triangle
puts my_triangle.perimeter
puts my_triangle.area


my_ellipse = Triangle.new(start_point, Point.new(1, 0), Point.new(0, 1))
puts my_ellipse
puts my_ellipse.perimeter
puts my_ellipse.area

my_circle = Circle.new(start_point, 3)
puts my_circle
puts my_circle.perimeter
puts my_circle.area

# Se espera la siguiente salida
# Rectángulo [ {0, 0} , {2, 4} ]
# 12
# 8
# Triángulo [ {0, 0} , {1, 0} , {0, 1} ]
# 3.414213562373095
# 0.49999999999999983
# Elipse [Centro: {0, 0}, DMayor: 2, DMenor: 1]
# 4.71238898038469
# 1.5707963267948966
# Círculo [Centro: {0, 0} , Radio: 3]
# 18.84955592153876
# 28.274333882308138
