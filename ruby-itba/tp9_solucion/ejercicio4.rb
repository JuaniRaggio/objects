#!/usr/bin/env ruby
require 'sorted_set'
require_relative '../tp8_solucion/point/point'
require_relative '../tp8_solucion/figures/circle'
require_relative '../tp8_solucion/figures/rectangle'
require_relative '../tp8_solucion/figures/figures'

# Entiendo que no va a poder comparar figuras asique tiraria un error, entonces tengo que modificar
# figures para que se pueda comparar un circulo con un rectangulo
module Figures
  def <=>(other)
    return nil unless other.is_a?(Figures)

    ret = area <=> other.area
    return ret unless ret.zero?
    perimeter <=> other.perimeter
  end
end

my_sorted_figure_set = SortedSet.new
my_sorted_figure_set.add(Rectangle.new(Point.new(10, 20), Point.new(20, 10)))
my_sorted_figure_set.add(Circle.new(Point.new(10, 20), 1))
my_sorted_figure_set.add(Circle.new(Point.new(10, 20), 3))
puts my_sorted_figure_set
