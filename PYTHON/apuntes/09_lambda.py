
# Definimos una función lambda que suma 10 al argumento de entrada
f = lambda x: x+10
# Evaluamos la función lambda con diferentes argumentos
val1 = f(5)  # Salida: 15
val2 = f(100)  # Salida: 110
print(val1, val2)

# Definimos una función lambda que multiplica dos argumentos de entrada y devuelve el resultado
f = lambda x,y: x*y
# Evaluamos la función lambda con diferentes pares de argumentos
val3 = f(2,10)  # Salida: 20
val4 = f(7,5)   # Salida: 35
print(val3, val4)

# Ejemplo de uso: Lambda dentro de otra función
# Devuelve una función lambda personalizada desde otra función
# Crea diferentes variaciones de función dependiendo de las necesidades
def myfunc(n):
    return lambda x: x * n

doubler = myfunc(2)
print(doubler(6))  # Salida: 12

tripler = myfunc(3)
print(tripler(6))  # Salida: 18

# Ejemplo de ordenación personalizada usando una función lambda como parámetro de clave
# La función clave transforma cada elemento antes de ordenarlo
points2D = [(1, 9), (4, 1), (5, -3), (10, 2)]
sorted_by_y = sorted(points2D, key=lambda x: x[1])
print(sorted_by_y)  # Salida: [(5, -3), (4, 1), (10, 2), (1, 9)]

mylist = [- 1, -4, -2, -3, 1, 2, 3, 4]
sorted_by_abs = sorted(mylist, key=lambda x: abs(x))
print(sorted_by_abs)  # Salida: [-1, 1, -2, 2, -3, 3, -4, 4]

# Uso de lambda para la función map
# map(func, seq), transforma cada elemento con la función
a = [1, 2, 3, 4, 5, 6]
b = list(map(lambda x: x * 2 , a))
# Sin embargo, intenta preferir la comprensión de listas
# Usa map si tienes una función ya definida
c = [x*2 for x in a]
print(b)  # Salida: [2, 4, 6, 8, 10, 12]
print(c)  # Salida: [2, 4, 6, 8, 10, 12]

# Uso de lambda para la función filter
# filter(func, seq), devuelve todos los elementos para los cuales func se evalúa como True
a = [1, 2, 3, 4, 5, 6, 7, 8]
b = list(filter(lambda x: (x%2 == 0) , a))
# Sin embargo, lo mismo se puede lograr con comprensión de listas
c = [x for x in a if x%2 == 0]
print(b)  # Salida: [2, 4, 6, 8]
print(c)  # Salida: [2, 4, 6, 8]

# reduce
# reduce(func, seq), aplica repetidamente func a los elementos y devuelve un único valor.
# func toma 2 argumentos.
from functools import reduce
a = [1, 2, 3, 4]
product_a = reduce(lambda x, y: x*y, a)
print(product_a)  # Salida: 24
sum_a = reduce(lambda x, y: x+y, a)
print(sum_a)  # Salida: 10