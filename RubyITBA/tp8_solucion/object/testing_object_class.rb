a = String.new('Hola Mundo')
b = String.new('Hola Mundo')
puts a == b # Entiendo  que true

# Esto depende si String sobreescribe o no a este operador y depende de como lo haga, me la juego que retorna true
puts a === b

puts a.eql? b # Esto entiendo que llama al == asique retorna true
puts a.equal? b # Esto retorna true si son el mismo objeto asique false

# Por lo que entendi de este operador, ruby lo usa para sobreescribir al ==
# hace la "resta" de toda la vida
# Por lo tanto en este caso va a retornar 0 porque son iguales
puts a <=> b
