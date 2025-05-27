require_relative 'figures'

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

  private :calculate_base, :calculate_height
end
