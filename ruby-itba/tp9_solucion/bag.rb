#!/usr/bin/env ruby
require_relative '../tp8_solucion/point/point'

# Son elementos sin orden pero se desea guardar la repeticion
# entonces nos quedaria una hash table
class Bag
  def initialize
    @bag = {}
  end

  def add(pt)
    @bag[pt] = 0 unless @bag.key?(pt)
    @bag[pt] += 1
  end

  def size
    @bag.size
  end

  def count(pt)
    @bag.select { |k, _| k == pt }.values.sum
  end

  # Esta es la solucion de la catedra pero esta mal porque retorna nil cuando borras
  # pero el test espera cero
  # def delete(element)
  #   @bag[element] -= 1 if @bag.key? element
  #   @bag.delete(element) if @bag[element].zero?
  #   @bag[element]
  # end

   def delete(pt)
     if @bag[pt] == 1
       @bag.delete(pt)
       return 0
     end
     @bag[pt] -= 1
   end

  # En el fondo hace esto pero el Hash ya tiene un to_s que lo hace asi
  # def to_s
  #   keys = @bag.keys
  #   s = ''
  #   keys.each {
  #     s += "#{it.to_s} => #{@bag[it].to_s}"
  #     s += ", " unless it == keys.last
  #   }
  #   "{#{s}}"
  # end

  def to_s
    @bag.to_s
  end

end

my_bag = Bag.new
my_bag.add(Point.new(0, 0))
my_bag.add(Point.new(1, 2))
my_bag.add(Point.new(3, 4))
my_bag.add(Point.new(1, 2))
puts my_bag
puts my_bag.size
puts my_bag.count(Point.new(1, 2))
puts my_bag.delete(Point.new(1, 2))
puts my_bag
puts my_bag.delete(Point.new(1, 2))
puts my_bag
