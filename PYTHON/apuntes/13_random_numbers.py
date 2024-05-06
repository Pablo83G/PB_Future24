
# Python define un conjunto de funciones que se utilizan para generar o manipular números aleatorios.
# Este artículo cubre:

# el módulo random
# reproducir números con random.seed()
# crear números aleatorios criptográficamente fuertes con el módulo secrets
# crear matrices nd aleatorias con numpy.random

# El módulo random
# Este módulo implementa generadores de números pseudoaleatorios para varias distribuciones. 
# Utiliza el algoritmo Mersenne Twister (https://en.wikipedia.org/wiki/Mersenne_Twister) como su generador principal. 
# Se llama pseudoaleatorio, porque los números parecen aleatorios, pero son reproducibles.

import random

# float aleatorio en [0,1)
a = random.random()
print(a)# 0.10426373452067317


# float aleatorio en el rango [a,b]
a = random.uniform(1,10)
print(a)# 3.34983979352444


# entero aleatorio en el rango [a,b]. b está incluido
a = random.randint(1,10)
print(a)# 3


# entero aleatorio en el rango [a,b). b está excluido
a = random.randrange(1,10)
print(a)# 4


# float aleatorio de una distribución normal con mu y sigma
a = random.normalvariate(0, 1)
print(a)# -1.004568769635799


# elige un elemento aleatorio de una secuencia
a = random.choice(list("ABCDEFGHI"))
print(a)# E


# elige k elementos aleatorios únicos de una secuencia
a = random.sample(list("ABCDEFGHI"), 3)
print(a)# ['G', 'C', 'B']

# elige k elementos con reemplazo y devuelve una lista de tamaño k
a = random.choices(list("ABCDEFGHI"),k=3)
print(a)# ['E', 'D', 'E']


# mezcla la lista en su lugar
a = list("ABCDEFGHI")
random.shuffle(a)
print(a)# ['D', 'I', 'G', 'H', 'E', 'B', 'C', 'F', 'A']


# El generador de semillas
# Con random.seed(), puedes hacer que los resultados sean reproducibles, y la cadena de llamadas después de random.seed()
# producirá la misma secuencia de datos. La secuencia de números aleatorios se vuelve determinista,
# o completamente determinada por el valor de la semilla.

print('Sembrando con 1...\n')

random.seed(1)
print(random.random())
print(random.uniform(1,10))
print(random.choice(list("ABCDEFGHI")))
# Sembrando con 1...

# 0.13436424411240122
# 8.626903632435095
# B


print('\nRe-sembrando con 42...\n')
random.seed(42)  # Re-sembrar

print(random.random())
print(random.uniform(1,10))
print(random.choice(list("ABCDEFGHI")))
# Re-sembrando con 42...

# 0.6394267984578837
# 1.2250967970040025
# E


print('\nRe-sembrando con 1...\n')
random.seed(1)  # Re-sembrar

print(random.random())
print(random.uniform(1,10))
print(random.choice(list("ABCDEFGHI")))
# Re-sembrando con 1...

# 0.13436424411240122
# 8.626903632435095
# B


print('\nRe-sembrando con 42...\n')
random.seed(42)  # Re-sembrar

print(random.random())
print(random.uniform(1,10))
print(random.choice(list("ABCDEFGHI")))

# Re-sembrando con 42...

# 0.6394267984578837
# 1.2250967970040025
# E

# El módulo secrets
# El módulo secrets se utiliza para generar números aleatorios criptográficamente fuertes adecuados para gestionar datos
# como contraseñas, autenticación de cuentas, tokens de seguridad y secretos relacionados.
# En particular, los secretos deben usarse en lugar del generador de números pseudoaleatorios predeterminado en el módulo 
# random, que está diseñado para modelado y simulación, no para seguridad o criptografía.

import secrets

# entero aleatorio en el rango [0, n).
a = secrets.randbelow(10)
print(a)# 6


# devuelve un entero con k bits aleatorios.
a = secrets.randbits(5)
print(a)# 6


# elige un elemento aleatorio de una secuencia
a = secrets.choice(list("ABCDEFGHI"))
print(a)# E


# Números aleatorios con NumPy
# Crea números aleatorios para matrices nd. El generador de números pseudoaleatorios NumPy es diferente del generador 
# de números pseudoaleatorios de la biblioteca estándar de Python.
# Es importante destacar que sembrar el generador de números pseudoaleatorios de Python no afecta al generador 
# de números pseudoaleatorios NumPy. Debe ser sembrado y utilizado por separado.

"""El módulo NumPy requiere instalación
import Numpy as np

np.random.seed(1)
# rand(d0,d1,…,dn)
# genera una matriz nd con floats aleatorios, la matriz tiene tamaño (d0,d1,…,dn)
print(np.random.rand(3))

np.random.seed(1)
print(np.random.rand(3))


# genera una matriz nd con enteros aleatorios en el rango [a,b) con tamaño n
values = np.random.randint(0, 10, (5,3))
print(values)

# genera una matriz nd con valores Gaussianos, la matriz tiene tamaño (d0,d1,…,dn)
# valores de la distribución normal estándar con media 0.0 y desviación estándar 1.0
values = np.random.randn(5)
print(values)


# mezcla aleatoriamente una matriz nd.
# solo mezcla la matriz a lo largo del primer eje de una matriz multidimensional
arr = np.array([[1,2,3], [4,5,6], [7,8,9]])
np.random.shuffle(arr)
print(arr)
"""
