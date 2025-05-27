require_relative 'figures'
require_relative 'ellipse'

class Circle < Ellipse
  def initialize(center, radius)
    super(center, 2 * radius, 2 * radius)
  end

  def to_s = "Circulo [Centro: #{@centre_point}, Radio: #{@smayor_axis / 2}]"
end
