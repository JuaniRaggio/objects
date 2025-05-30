require_relative '../point/point'
require_relative '../../tp10_solucion/movable'

# En realidad deberia ser una clase abstracta, pero todavia no me cierran las clases
# abstractas de ruby, porque me tira siempre warnings
module Figures
  include Movable
  def area()
    raise NotImplementedError, 'Implementation missing: area'
  end

  def perimeter()
    raise NotImplementedError, 'Implementation missing: perimeter'
  end
end
