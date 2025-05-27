require_relative 'ComplexNumber'

# Preguntan que se obtiene si se quitan las invocaciones to_s de real e imaginary
first_complex = ComplexNumber.new(2, -1)
second_complex = ComplexNumber.new(3, 0)

res_complex = first_complex + second_complex

# Si sacara el to_s lo que va a pasar es que no va a poder sumar un entero con un string ' + ', lo mismo
# con 'i'
puts res_complex.real.to_s + ' + ' + res_complex.imaginary.to_s + 'i'
