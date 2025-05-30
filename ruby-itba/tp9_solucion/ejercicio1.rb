#!/usr/bin/env ruby

my_array = [9, 5, 1, 2, 3, 4, 0, -1]
p my_array.size
# 8

p my_array.first
# 9

p my_array.last
# -1

p my_array[1]
# 5

p my_array[9] # Overflow (?
# NO, tira nil
# nil

p my_array[2..4]
# [1, 2, 3]

p my_array[2...4] # No incluye el valor final, entonces:
# [1, 2]

p my_array[2, 4] # Creo que no existe esto, SI existe y es lo siguiente: [inicio, cantidad], entonces printea:
# [1, 2, 3, 4]

p my_array[-3] # Son ciclicos hacia atras los arreglos
# 4

p my_array.first(4) # Esto me retorna los primeros 4 elementos
# [9, 5, 1, 2]

p my_array.drop(4) # drop retorna un arreglo ignorando los elementos que se pasan por parametro
# [3, 4, 0, -1]


# Estos metodos no son bang methods pero segun gpt modifican el arreglo

p my_array.prepend(10, 11) # Agrega al inicio el 10 y el 11
# [10, 11, 9, 5, 1, 2, 3, 4, 0, -1]

p my_array.append(20, 21)
# [10, 11, 9, 5, 1, 2, 3, 4, 0, -1, 20, 21]


p(my_array.map { |e| e * 3 }) # Le va a aplicar a todos los elemntos un *3 pero no los modifica
# [30, 33, 27, 15, 3, 6, 9, 12, 0, -3, 60, 63]

p(my_array.map { |e| e * 3 }.reduce { |sum, e| sum + e }) # Vuelve a multiplicar por 3 y hace la suma
# 255
