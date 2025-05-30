#!/usr/bin/env ruby
module Movable
  def move_up(delta)
    points.map! { |pt| pt.move_up(delta) }
  end

  def move_down(delta)
    points.map! { |pt| pt.move_down(delta) }
  end

  def move_left(delta)
    points.map! { |pt| pt.move_left(delta) }
  end

  def move_right(delta)
    points.map! { |pt| pt.move_right(delta) }
  end
end

class Point
  include Moveable

  def initialize(x, y)
    @x = x
    @y = y
  end

  def to_s
    "{#{@x}, #{@y}}"
  end

  def distance(other)
    return self if other.nil? || !other.is_a?(Point)

    Math.sqrt((@x - other.x)**2 + (@y - other.y)**2)
  end

  # Esto es muyy importante, quiero que los puntos sean protected
  # ya que solo me interesa tener el reader para distance, cuando quiero
  # acceder al x e y del other
  attr_reader :x, :y

  # Esto es parte del ejercicio 9
  def ==(other)
    return false unless other.is_a?(Point)

    @x == other.x && @y == other.y
  end

  def hash
    [@x, @y].hash
  end

  alias_method :eql?, :==
  alias_method :inspect, :to_s

  def move_up(delta)
    @y += delta
  end

  def move_down(delta)
    @y -= delta
  end

  def move_left(delta)
    @x -= delta
  end

  def move_right(delta)
    @x += delta
  end
end

module Figures
  def area()
    raise NotImplementedError, 'Implementation missing: area'
  end

  def perimeter()
    raise NotImplementedError, 'Implementation missing: perimeter'
  end
end

class Rectangle
  include Figures

  def initialize(top_left_corner, bottom_right_corner)
    @top_left_corner = top_left_corner
    @bottom_right_corner = bottom_right_corner
  end

  def base = (@top_left_corner.x - @bottom_right_corner.x).abs

  def height = (@top_left_corner.y - @bottom_right_corner.y).abs

  def area = base * height

  def perimeter = 2 * (base + height)

  def to_s = "Rectangulo [ {#{@top_left_corner.to_s}, #{@bottom_right_corner.to_s}}]"

  def hash
    [@top_left_corner, @bottom_right_corner].hash
  end

  # Esto es parte del ejercicio 9
  def ==(other)
    return false unless other.is_a?(Rectangle)

    @top_left_corner == other.top_left_corner && @bottom_right_corner == other.bottom_right_corner
  end

  alias_method :eql?, :==
  alias_method :inspect, :to_s

  protected

  attr_reader :top_left_corner, :bottom_right_corner
end

class MovableRectangle < Rectangle
  include Movable

  def points = [@top_left_corner, @bottom_right_corner]

end

class Ellipse
  include Figures

  def initialize(center_point, smayor_axis, sminor_axis)
    @center_point = center_point
    @smayor_axis = smayor_axis
    @sminor_axis = sminor_axis
  end

  def area
    Math::PI / 4 * @smayor_axis * @sminor_axis
  end

  def perimeter
    Math::PI / 2 * (@smayor_axis + @sminor_axis)
  end

  def to_s
    "Elipse [Centro: #{@center_point}, DMayor: #{@smayor_axis}, DMenor: #{@sminor_axis}]"
  end

  # Esto es parte del ejercicio 9
  def ==(other)
    return false unless other.is_a?(Ellipse)

    @center_point == other.center_point && @smayor_axis == other.smayor_axis && @sminor_axis == other.sminor_axis
  end

  def hash
    [@centre_point, @smayor_axis, @sminor_axis].hash
  end

  alias_method :eql?, :==
  alias_method :inspect, :to_s

  protected

  attr_reader :center_point, :smayor_axis, :sminor_axis
end

class MovableEllipse < Ellipse
  include Movable

  def points = [@center_point]

end

class Circle < Ellipse
  include Figures
  def initialize(center, radius)
    super(center, 2 * radius, 2 * radius)
  end

  def to_s = "Circulo [Centro: #{@center_point}, Radio: #{@smayor_axis.distance(@center_point)}]"
  alias_method :inspect, :to_s
end

class MovableCircle < MovableEllipse
end

class Triangle
  include Figures

  def initialize(left_corner, right_corner, top_corner)
    @left_corner = left_corner
    @right_corner = right_corner
    @top_corner = top_corner
  end

  def to_s = "Triangulo [ {#{@left_corner}}, {#{@right_corner}}, {#{@top_corner}} ]"

  def calculate_base = @left_corner.distance(@right_corner)

  def calculate_height = @left_corner.distance(@top_corner)

  def calculate_hypotenuse = @right_corner.distance(@top_corner)

  def area = calculate_base * calculate_height / 2

  def perimeter = calculate_base + calculate_height + calculate_hypotenuse

  def hash
    [@left_corner, @right_corner, @top_corner].hash
  end

  def ==(other)
    return false unless other.is_a?(Triangle)

    @left_corner == other.left_corner && @right_corner == other.right_corner && @top_corner == other.top_corner
  end

  alias_method :eql?, :==
  alias_method :inspect, :to_s

  protected attr_reader :left_corner, :right_corner, :top_corner

  private :calculate_base, :calculate_height, :calculate_hypotenuse
end

class MovableTriangle < Triangle
  include Movable

  def points = [@left_corner, @right_corner, @top_corner]
end
