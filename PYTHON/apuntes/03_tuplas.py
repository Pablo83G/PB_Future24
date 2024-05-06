# Tuplas: ordenadas, inmutables, permiten elementos duplicados
mytuple = ('a','p','p','l','e')
mytuplex=tuple("Jenn", 32, "Cuenca")
#mytuple = "Jenn", 32, "Cuenca" los parentesis son opcionales

"""
Un elemento solo dentro de una tupla, hará que no se detecte como tal para ello debemos añadir una , detrás del elemento que contenga la tupla:
mytuple = ("Jenn",)
"""

# Acceder a elementos
first_item = mytuple[0]
last_item = mytuple[-1]

#Destructuring 
name, age, city = mytuplex
print(name, age, city)

my_other_tupla=(0, 1, 2, 3, 4)
i1, *i2, i3 = my_other_tupla

print(i1) # 0
print(i2) # 1,2,3
print(i3) # 4

# Iterar sobre una tupla
for item in mytuple:
    print(item)

# Verificar si un elemento está en la tupla
if "a" in mytuple:
    print("Sí")
else:
    print("No")

# Longitud de la tupla
print(len(mytuple))



# Concatenar tuplas
new_tuple = mytuple + ("lemon", "blueberry")
print(new_tuple)

# Obtener el indie del primer elemento que encuentre como el dado por parametro
index = mytuple.index("p")
print("Index of 'p':", index)

# Contar la ocurrencia de un elemento en la tupla
count = mytuple.count("a")
print("Count of 'a':", count)

# Funciones dentro de un bucle
my_tuple_num = (1, 2, 3, 4, 5, 6)
# Utilizamos una expresión de tupla con una función para calcular el cuadrado de cada número en my_tuple_num
tuple_square_num = tuple(i*i for i in my_tuple_num)
print(tuple_square_num)  # Imprime los cuadrados de los números en my_tuple_num

# Slicing
my_num_tuple = (1, 2, 3, 4, 5, 6, 7, 8, 9)

# Obtener una subtupla desde el segundo hasta el quinto elemento
subtuple = my_num_tuple[1:5]
print(subtuple)  # Output: (2, 3, 4, 5)

# Obtener los últimos tres elementos de la tupla
last_three = my_num_tuple[-3:]
print(last_three)  # Output: (7, 8, 9)

# Obtener una copia completa de la tupla
copy_of_tuple = my_num_tuple[:]
print(copy_of_tuple)  # Output: (1, 2, 3, 4, 5, 6, 7, 8, 9)

# Revertir la tupla
reversed_tuple = my_num_tuple[::-1]
print(reversed_tuple)  # Output: (9, 8, 7, 6, 5, 4, 3, 2, 1)