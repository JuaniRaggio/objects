require_relative 'figures'

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
end
