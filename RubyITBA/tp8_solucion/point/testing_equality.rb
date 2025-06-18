require_relative 'point'

my_point = Point.new(1, 2)

# Esto si o si true, haga lo que haga deberia dar true porque son literalmente
# lo mismo en todo sentido
puts my_point == my_point

# Este ya me mataste, entiendo que va a retornar FalseClass
# porque no lo sobreescribimos y va a usar a equals? que Compa la
# direccion de memoria
puts my_point == Point.new(1, 2)

# Devuelve true si o si
puts my_point != Point.new(3, 4)

# Devuelve false si o si o incluso puede que retorne un error
puts my_point == 'Hola Mundo'
