"""
Las itertools en Python son un módulo estándar que proporciona diversas herramientas para trabajar
 con iteradores de manera eficiente. 
 Los iteradores son objetos que pueden ser atravesados uno a la vez. 
 El módulo itertools ofrece funciones para crear, combinar y manipular iteradores de formas útiles y eficientes.

Algunas de las funcionalidades que proporciona itertools incluyen:

Generación de combinaciones y permutaciones.
Operaciones de acumulación.
Agrupación de elementos en base a ciertos criterios.
Generación de productos cartesianos.
Creación de iteradores infinitos, como contar desde un número específico o ciclar a través de una secuencia infinitamente.
En resumen, itertools es una herramienta poderosa para trabajar con iteradores de una manera más eficiente y concisa en Python.
"""
# Importamos la función product del módulo itertools
from itertools import product

# Creamos el producto cartesiano de dos listas
prod = product([1, 2], [3, 4])
#Para poder ver el producto cartesiano lo convertimos en una lista
print(list(prod))  # Salida: [(1, 3), (1, 4), (2, 3), (2, 4)]

# Especificamos el número de repeticiones para permitir el producto de un iterable consigo mismo
prod = product([1, 2], [3], repeat=2)
# Imprimimos el producto cartesiano convertido a lista
print(list(prod))  # Salida: [(1, 3, 1, 3), (1, 3, 2, 3), (2, 3, 1, 3), (2, 3, 2, 3)]

# Importamos la función permutations del módulo itertools
from itertools import permutations

# Generamos las permutaciones de una lista
perm = permutations([1, 2, 3])
# Imprimimos las permutaciones convertidas a lista
print(list(perm))  # Salida: [(1, 2, 3), (1, 3, 2), (2, 1, 3), (2, 3, 1), (3, 1, 2), (3, 2, 1)]

# Especificamos la longitud de las tuplas de permutaciones
perm = permutations([1, 2, 3], 2)
# Imprimimos las permutaciones convertidas a lista
print(list(perm))  # Salida: [(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)]

# Importamos las funciones combinations y combinations_with_replacement del módulo itertools
from itertools import combinations, combinations_with_replacement

# Generamos combinaciones de longitud r en orden ordenado
comb = combinations([1, 2, 3, 4], 2)
# Imprimimos las combinaciones convertidas a lista
print(list(comb))  # Salida: [(1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)]

# Generamos combinaciones con reemplazo
comb = combinations_with_replacement([1, 2, 3, 4], 2)
# Imprimimos las combinaciones convertidas a lista
print(list(comb))  # Salida: [(1, 1), (1, 2), (1, 3), (1, 4), (2, 2), (2, 3), (2, 4), (3, 3), (3, 4), (4, 4)]

# Importamos la función accumulate del módulo itertools
from itertools import accumulate

# Generamos sumas acumuladas
acc = accumulate([1,2,3,4])
# Imprimimos las sumas acumuladas
print(list(acc))  # Salida: [1, 3, 6, 10]

# Generamos resultados acumulados con una función específica, por ejemplo multiplicar
import operator
acc = accumulate([1,2,3,4], func=operator.mul)
# Imprimimos los resultados acumulados
print(list(acc))  # Salida: [1, 2, 6, 24]

# Generamos resultados acumulados con la función máxima
acc = accumulate([1,5,2,6,3,4], func=max)
# Imprimimos los resultados acumulados
print(list(acc))  # Salida: [1, 5, 5, 6, 6, 6]

# Importamos la función groupby del módulo itertools
from itertools import groupby

# Definimos una función para usar como clave en la agrupación
def smaller_than_3(x):
    return x < 3

# Agrupamos los elementos según la función clave definida
group_obj = groupby([1, 2, 3, 4], key=smaller_than_3)
# Iteramos sobre los grupos y sus claves
for key, group in group_obj:
    print(key, list(group))

# Agrupamos los elementos según una expresión lambda
group_obj = groupby(["hi", "nice", "hello", "cool"], key=lambda x: "i" in x)
# Iteramos sobre los grupos y sus claves
for key, group in group_obj:
    print(key, list(group))

# Agrupamos elementos de un diccionario según el valor de una clave específica
persons = [{'name': 'Tim', 'age': 25}, {'name': 'Dan', 'age': 25}, 
           {'name': 'Lisa', 'age': 27}, {'name': 'Claire', 'age': 28}]
for key, group in groupby(persons, key=lambda x: x['age']):
    print(key, list(group))

# Importamos las funciones count, cycle y repeat del módulo itertools
from itertools import count, cycle, repeat

# Generamos una secuencia contando desde 10
for i in count(10):
    print(i)
    if i >= 13:
        break

# Iteramos infinitamente sobre un iterable
print("")
sum = 0
for i in cycle([1, 2, 3]):
    print(i)
    sum += i
    if sum >= 12:
        break

# Repetimos un elemento un número específico de veces
print("")
for i in repeat("A", 3):
    print(i)

