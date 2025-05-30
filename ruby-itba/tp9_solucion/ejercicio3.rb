require_relative '../tp8_solucion/figures/circle'
require_relative '../tp8_solucion/figures/rectangle'

point_set = Set.new
point_set.add(Point.new(1, 2))
point_set.add(Point.new(3, 4))
point_set.add(Point.new(1, 2))
puts point_set

my_figure_set = Set.new
my_figure_set.add(Circle.new(Point.new(10, 20), 15))
my_figure_set.add(Circle.new(Point.new(10, 20), 15))
my_figure_set.add(Rectangle.new(Point.new(10, 20), Point.new(20, 10)))
puts my_figure_set
