require_relative 'figures'
require_relative 'ellipse'

class Circle < Ellipse
  include Figures
  def initialize(center, radius)
    super(center, 2 * radius, 2 * radius)
  end

  def to_s = "Circulo [Centro: #{@center_point}, Radio: #{@smayor_axis.distance(@center_point)}]"
  alias_method :inspect, :to_s
end
