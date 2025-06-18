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
