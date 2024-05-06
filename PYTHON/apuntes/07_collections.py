# Importamos el módulo collections
from collections import Counter, namedtuple, OrderedDict, defaultdict, deque

# Counter: Cuenta elementos y sus ocurrencias

# Creamos una cadena con caracteres repetidos
a = "aaaaabbbbcccdde"

# Creamos un objeto Counter para contar las ocurrencias de elementos
my_counter = Counter(a)

# Imprimimos el Counter (formato tipo diccionario)
print("Conteo de elementos:", my_counter)  # Salida: Counter({'a': 5, 'b': 4, 'c': 3, 'd': 2, 'e': 1})

# Imprimimos elementos (pares clave-valor)
print("Elementos:", my_counter.items())  # Salida: dict_items([('a', 5), ('b', 4), ('c', 3), ('d', 2), ('e', 1)])

# Imprimimos claves (elementos únicos)
print("Elementos únicos:", my_counter.keys())  # Salida: dict_keys(['a', 'b', 'c', 'd', 'e'])

# Imprimimos valores (conteos)
print("Conteos:", my_counter.values())  # Salida: dict_values([5, 4, 3, 2, 1])

# Creamos una lista con elementos repetidos
my_list = [0, 1, 0, 1, 2, 1, 1, 3, 2, 3, 2, 4]

# Creamos un Counter a partir de la lista
my_counter = Counter(my_list)

# Imprimimos el Counter
print("\nConteo de elementos de la lista:", my_counter)  # Salida: Counter({1: 4, 2: 3, 0: 2, 3: 2, 4: 1})

# Encontramos el elemento más común (limitado al 1ª)
most_common = my_counter.most_common(1)
print("Elemento más común (conteo):", most_common)  # Salida: [(1, 4)]

# Obtenemos un iterador para elementos con conteos repetidos
elements = my_counter.elements()

# Convertimos el iterador a una lista para poder imprimir los datos (los elementos se devuelven en orden arbitrario)
element_list = list(elements)
print("\nElementos con conteos repetidos (en orden arbitrario):", element_list)
                                 # Salida: [0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4]


# namedtuple: Crea objetos ligeros con campos nombrados

# Definimos una namedtuple para puntos con coordenadas x e y
Point = namedtuple('Point', 'x, y')

# Creamos un objeto Point
pt = Point(1, -4)

# Imprimimos el objeto Point (como una tupla)
print("\nCoordenadas del punto:", pt)  # Salida: Point(x=1, y=-4)

# Accedemos a los campos por nombre
print("Coordenada X:", pt.x)      # Salida: Coordenada X: 1
print("Coordenada Y:", pt.y)      # Salida: Coordenada Y: -4

# Definimos una namedtuple para Persona con nombre y edad
Person = namedtuple('Person', 'name, age')

# Creamos un objeto Persona
friend = Person(name='Tom', age=25)

# Accedemos a los campos por nombre
print("\nNombre del amigo:", friend.name)    # Salida: Nombre del amigo: Tom
print("Edad del amigo:", friend.age)       # Salida: Edad del amigo: 25


# OrderedDict: Mantiene el orden de inserción para diccionarios

# Creamos un diccionario ordinario en versiones de python anteriores a 3.7 el orden no se conservaba, ahora si.
ordinary_dict = {}
ordinary_dict['b'] = 2
ordinary_dict['c'] = 3
ordinary_dict['d'] = 4
ordinary_dict['e'] = 5
ordinary_dict['a'] = 1
print("\nDiccionario ordinario (el orden puede variar):")
for key, value in ordinary_dict.items():
    print(key, value)
# Salida:    
# Diccionario ordinario (el orden puede variar):
# b 2
# c 3
# d 4
# e 5
# a 1

# Creamos un OrderedDict (los elementos se mantienen en el orden de inserción)
ordered_dict = OrderedDict()
ordered_dict['a'] = 1
ordered_dict['b'] = 2
ordered_dict['c'] = 3
ordered_dict['d'] = 4
ordered_dict['e'] = 5

print("\nDiccionario ordenado (elementos en el orden de inserción):")
for key, value in ordered_dict.items():
    print(key, value)


# defaultdict: Proporciona un valor predeterminado para las claves que faltan

# Creamos un defaultdict con un valor predeterminado de 0 para enteros
d = defaultdict(int)

# Agregamos elementos al defaultdict
d['yellow'] = 1
d['blue'] = 2

# Imprimimos los elementos del defaultdict (formato tipo diccionario)
print("\nElementos del defaultdict (con valor predeterminado 0 para enteros):")
for key, value in d.items():
    print(key, value)

# Accedemos a una clave que no existe en el defaultdict (devuelve el valor predeterminado)
print("Valor de la clave 'green':", d['green'])  # Salida: Valor de la clave 'green': 0

# Creamos un defaultdict con un valor predeterminado de una lista vacía
d = defaultdict(list)

# Creamos una lista de pares clave-valor
s = [('yellow', 1), ('blue', 2), ('yellow', 3), ('blue', 4), ('red', 5)]

# Agregamos elementos al defaultdict utilizando la lista
for key, value in s:
    d[key].append(value)

# Imprimimos los elementos del defaultdict (formato tipo diccionario)
print("\nElementos del defaultdict (con valor predeterminado de una lista vacía):")
for key, value in d.items():
    print(key, value)

# Accedemos a una clave que no existe en el defaultdict (devuelve la lista vacía predeterminada)
print("Valor de la clave 'green':", d['green'])  # Salida: Valor de la clave 'green': []


# deque: Cola de doble extremo

# Creamos una deque vacía
d = deque()

# Agregamos elementos al final de la deque
d.append('a')
d.append('b')

# Imprimimos la deque
print("\nElementos de la deque (después de agregar 'a' y 'b'):", d)  
# Salida: Elementos de la deque (después de agregar 'a' y 'b'): deque(['a', 'b'])

# Agregamos elementos al principio de la deque
d.appendleft('c')

# Imprimimos la deque
print("Elementos de la deque (después de agregar 'c' al principio):", d)  
# Salida: Elementos de la deque (después de agregar 'c' al principio): deque(['c', 'a', 'b'])

# Eliminamos un elemento del final de la deque y lo devolvemos
print("Elemento eliminado del final:", d.pop())  # Salida: Elemento eliminado del final: 'b'

# Imprimimos la deque
print("Elementos de la deque (después de eliminar el final):", d)  
# Salida: Elementos de la deque (después de eliminar el final): deque(['c', 'a'])

# Eliminamos un elemento del principio de la deque y lo devolvemos
print("Elemento eliminado del principio:", d.popleft())  # Salida: Elemento eliminado del principio: 'c'

# Imprimimos la deque
print("Elementos de la deque (después de eliminar el principio):", d)  # Salida: Elementos de la deque (después de eliminar el principio): deque(['a'])

# Eliminamos todos los elementos de la deque
d.clear()

# Imprimimos la deque vacía
print("\nElementos de la deque después de limpiarla:", d)  # Salida: Elementos de la deque después de limpiarla: deque([])

# Creamos una deque a partir de una lista
d = deque(['a', 'b', 'c', 'd'])

# Agregamos elementos al final de la deque
d.extend(['e', 'f', 'g'])

# Agregamos elementos al principio de la deque
d.extendleft(['h', 'i', 'j'])

# Imprimimos la deque (los elementos se ordenan de izquierda a derecha)
print("\nElementos de la deque (después de agregar y extender):", d)
# Salida: Elementos de la deque (después de agregar y extender): deque(['j', 'i', 'h', 'a', 'b', 'c', 'd', 'e', 'f', 'g'])

# count(x) : returns the number of found elements
print(d.count('h')) #1

# movera todos los elementos 1 posiciones a la derecha
d.rotate(1)
print(d)    # salida(['g', 'j', 'i', 'h', 'a', 'b', 'c', 'd', 'e', 'f'])

# movera todos los elementos 2 posiciones a la izquierda
d.rotate(-2)
print(d)    # salida(['i', 'h', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'j'])