# Un conjunto es un tipo de datos de colección desordenado que no está indexado, mutable y no tiene elementos duplicados. Los conjuntos se crean con llaves.

# Crear un conjunto¶
# Use llaves o la función set integrada.

# Crear un conjunto vacío
my_set = {"apple", "banana", "cherry"}
print(my_set)  # Salida: {'banana', 'apple', 'cherry'}

# O use la función set y cree a partir de un iterable, por ejemplo, lista, tupla, cadena
my_set_2 = set(["one", "two", "three"])
my_set_2 = set(("one", "two", "three"))
print(my_set_2)  # Salida: {'three', 'one', 'two'}

my_set_3 = set("aaabbbcccdddeeeeeffff")
print(my_set_3)  # Salida: {'b', 'c', 'd', 'e', 'f', 'a'}
# Al convertir la cadena "aaabbbcccdddeeeeeffff" en un conjunto, se eliminan los duplicados y se obtienen los caracteres únicos.

# Tenga cuidado: un conjunto vacío no se puede crear con {}, ya que esto se interpreta como un dict
# use set() en su lugar
a = {}
print(type(a))  # Salida: <class 'dict'>
a = set()
print(type(a))  # Salida: <class 'set'>

# Añadir elementos¶
my_set = set()

# use el método add() para agregar elementos
my_set.add(42)
my_set.add(True)
my_set.add("Hello")

# nota: el orden no importa y puede diferir al imprimir
print(my_set)  # Salida: {True, 42, 'Hello'}

# nada sucede cuando el elemento ya está presente:
my_set.add(42)
print(my_set)  # Salida: {True, 42, 'Hello'}

# Eliminar elementos¶
# remove(x): elimina x, genera un KeyError si el elemento no está presente
my_set = {"apple", "banana", "cherry"}
my_set.remove("apple")
print(my_set)  # Salida: {'banana', 'cherry'}

# KeyError:
# my_set.remove("orange")

# discard(x): elimina x, no hace nada si el elemento no está presente
my_set.discard("cherry")
my_set.discard("blueberry")
print(my_set)  # Salida: {'banana'}

# clear() : eliminar todos los elementos
my_set.clear()
print(my_set)  # Salida: set()

# pop() : devuelve y elimina un elemento aleatorio
a = {True, 2, False, "hi", "hello"}
print(a.pop())  # Salida: False
print(a)  # Salida: {True, 2, 'hi', 'hello'}

# Verificar si el elemento está en el conjunto¶
my_set = {"apple", "banana", "cherry"}
if "apple" in my_set:
    print("sí")  # Salida: sí

# Iterando¶
# Iterar sobre un conjunto usando un bucle for in
# Nota: el orden no es importante
my_set = {"apple", "banana", "cherry"}
for i in my_set:
    print(i)  # Salida: 'banana', 'apple', 'cherry'

# Unión e intersección¶
impares = {1, 3, 5, 7, 9}
pares = {0, 2, 4, 6, 8}
primos = {2, 3, 5, 7}

# unión() : combina elementos de ambos conjuntos, sin duplicados
# tenga en cuenta que esto no cambia los dos conjuntos
u = impares.union(pares)
print(u)  # Salida: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

# intersección(): toma elementos que están en ambos conjuntos
i = impares.intersection(pares)
print(i)  # Salida: set()

i = impares.intersection(primos)
print(i)  # Salida: {3, 5, 7}

i = pares.intersection(primos)
print(i)  # Salida: {2}

# Diferencia de conjuntos¶
conjuntoA = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoB = {1, 2, 3, 10, 11, 12}

# difference() : devuelve un conjunto con todos los elementos del conjuntoA que no están en el conjuntoB.
diff_set = conjuntoA.difference(conjuntoB)
print(diff_set)  # Salida: {4, 5, 6, 7, 8, 9}

# La diferencia de A con respecto a B no es igual a la diferencia de B con respecto a A
diff_set = conjuntoB.difference(conjuntoA)
print(diff_set)  # Salida: {10, 11, 12}

# symmetric_difference() : devuelve un conjunto con todos los elementos que están en conjuntoA y conjuntoB pero no en ambos
diff_set = conjuntoA.symmetric_difference(conjuntoB)
print(diff_set)  # Salida: {4, 5, 6, 7, 8, 9, 10, 11, 12}

# La diferencia simétrica de A con respecto a B es igual a la diferencia simétrica de B con respecto a A
diff_set = conjuntoB.symmetric_difference(conjuntoA)
print(diff_set)  # Salida: {4, 5, 6, 7, 8, 9, 10, 11, 12}

# Actualización de conjuntos¶
conjuntoA = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoB = {1, 2, 3, 10, 11, 12}

# update
#() : actualiza el conjunto agregando elementos de otro conjunto.
conjuntoA.update(conjuntoB)
print(conjuntoA)  # Salida: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}

# intersection_update() : actualiza el conjunto manteniendo solo los elementos encontrados en ambos
conjuntoA = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoA.intersection_update(conjuntoB)
print(conjuntoA)  # Salida: {1, 2, 3}

# difference_update() : actualiza el conjunto eliminando los elementos que se encuentran en otro conjunto.
conjuntoA = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoA.difference_update(conjuntoB)
print(conjuntoA)  # Salida: {4, 5, 6, 7, 8, 9}

# symmetric_difference_update() : actualiza el conjunto manteniendo solo los elementos que se encuentran en uno u otro conjunto, pero no en ambos
conjuntoA = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoA.symmetric_difference_update(conjuntoB)
print(conjuntoA)  # Salida: {1, 2, 3, 10, 11, 12}

# Nota: todos los métodos de actualización también funcionan con otros iterables como argumento, por ejemplo, listas, tuplas
# conjuntoA.update([1, 2, 3, 4, 5, 6])

# Copiando
conjunto_org = {1, 2, 3, 4, 5}

# esto solo copia la referencia al conjunto, así que tenga cuidado
conjunto_copia = conjunto_org

# ahora, modificar la copia también afecta al original
conjunto_copia.update([3, 4, 5, 6, 7])
print(conjunto_copia)  # Salida: {1, 2, 3, 4, 5, 6, 7}
print(conjunto_org)  # Salida: {1, 2, 3, 4, 5, 6, 7}

# use copy() para copiar realmente el conjunto
conjunto_org = {1, 2, 3, 4, 5}
conjunto_copia = conjunto_org.copy()

# ahora, modificar la copia no afecta al original
conjunto_copia.update([3, 4, 5, 6, 7])
print(conjunto_copia)  # Salida: {1, 2, 3, 4, 5, 6, 7}
print(conjunto_org)  # Salida: {1, 2, 3, 4, 5}

# Subconjunto, superconjunto y disyunto¶
conjuntoA = {1, 2, 3, 4, 5, 6}
conjuntoB = {1, 2, 3}
# issubset(conjuntoX): Devuelve True si conjuntoX contiene el conjunto
print(conjuntoA.issubset(conjuntoB))  # Salida: False
print(conjuntoB.issubset(conjuntoA))  # Salida: True

# issuperset(conjuntoX): Devuelve True si el conjunto contiene conjuntoX
print(conjuntoA.issuperset(conjuntoB))  # Salida: True
print(conjuntoB.issuperset(conjuntoA))  # Salida: False

# isdisjoint(conjuntoX) : Devuelve True si ambos conjuntos tienen una intersección nula, es decir, no tienen elementos iguales
conjuntoC = {7, 8, 9}
print(conjuntoA.isdisjoint(conjuntoB))  # Salida: False
print(conjuntoA.isdisjoint(conjuntoC))  # Salida: True

# Frozenset
# Frozenset es simplemente una versión inmutable del conjunto normal.
# Mientras que los elementos de un conjunto se pueden modificar en cualquier momento,
# los elementos del frozenset permanecen iguales después de la creación. 
# Creación con: my_frozenset = frozenset(iterable)

a = frozenset([0, 1, 2, 3, 4])

# Lo siguiente no está permitido:
# a.add(5)
# a.remove(1)
# a.discard(1)
# a.clear()

# Tampoco se permiten los métodos de actualización:

# Otras operaciones de conjunto funcionan
impares = frozenset({1, 3, 5, 7, 9})
pares = frozenset({0, 2, 4, 6, 8})
print(impares.union(pares))  # Salida: frozenset({0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
print(impares.intersection(pares))  # Salida: frozenset()
print(impares.difference(pares))  # Salida: frozenset({1, 3, 5, 7, 9})