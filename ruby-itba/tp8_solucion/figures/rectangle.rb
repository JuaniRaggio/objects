require_relative 'figures'

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
