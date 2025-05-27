class Point
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

  attr_reader :x, :y
end
