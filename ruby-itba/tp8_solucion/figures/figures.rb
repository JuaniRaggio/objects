require_relative '../point/point'

# En realidad deberia ser una clase abstracta, pero todavia no me cierran las clases
# abstractas de ruby, porque me tira siempre warnings
module Figures
  def area()
    raise NotImplementedError, 'Implementation missing: area'
  end

  def perimeter()
    raise NotImplementedError, 'Implementation missing: perimeter'
  end
end
