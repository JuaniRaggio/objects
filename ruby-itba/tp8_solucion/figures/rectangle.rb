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
end
