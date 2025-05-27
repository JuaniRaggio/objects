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

  # TODO
  # Esto es muyy importante, quiero que los puntos sean protected
  # ya que solo me interesa tener el reader para distance, cuando quiero
  # acceder al x e y del other
  attr_reader :x, :y

  # Esto es parte del ejercicio 9
  def ==(other)
    return false unless other.is_a?(Point)

    @x == other.x && @y == other.y
  end
end
