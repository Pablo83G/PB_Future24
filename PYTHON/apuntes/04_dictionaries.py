# Diccionarios: estructura de datos asociativa, mutable, no permite claves duplicadas
empty_dict = {}  # Diccionario vacío

# Diccionario con datos
dct = {'name': 'Jennifer', 'age': 32, 'city': 'Cuenca', 'key4': 'value4'}

# Otra forma de crear un diccionario
dct2 = dict(name="Mary", age=27, city="Boston")

# Acceder a un valor mediante su clave
value = dct["age"]
print(value)  # Output: 32

# Añadir valores al diccionario (si la clave existe, se actualiza su valor)
dct["email"] = "jen@xyz.com"
print(dct)  # Output: {'name': 'Jennifer', 'age': 32, 'city': 'Cuenca', 'key4': 'value4', 'email': 'jen@xyz.com'}

dct["email"] = "jmp99@xyz.com"
print(dct)  # Output: {'name': 'Jennifer', 'age': 32, 'city': 'Cuenca', 'key4': 'value4', 'email': 'jmp99@xyz.com'}

# Eliminar un par clave-valor del diccionario
del dct["key4"]
print(dct)  # Output: {'name': 'Jennifer', 'age': 32, 'city': 'Cuenca', 'email': 'jmp99@xyz.com'}

# Eliminar y devolver el valor de una clave específica utilizando pop()
age = dct.pop("age")
print(age)  # Output: 32
print(dct)  # Output: {'name': 'Jennifer', 'city': 'Cuenca', 'email': 'jmp99@xyz.com'}

# Eliminar y devolver un par clave-valor arbitrario utilizando popitem(), quita el ultimo par
item = dct.popitem()
print(item)  # Output: ('email', 'jmp99@xyz.com')

print(dct)  # Output: {'name': 'Jennifer', 'city': 'Cuenca'}

# Uso de la declaración if para comprobar la existencia de una clave en el diccionario
if "name" in dct:
    print("La clave 'name' existe en el diccionario.")
    
# Uso de try y except para manejar excepciones al acceder a claves inexistentes
try:
    value = dct["gender"]
    print(value)
except KeyError:
    print("La clave 'gender' no existe en el diccionario.")
    
# Uso de la declaración for para iterar sobre las claves del diccionario
# Itera sobre las claves del diccionario 'dct' e imprime cada clave
for key in dct:
    print(key)

# Uso de la declaración for y el método keys() para iterar sobre las claves del diccionario
# Itera sobre las claves del diccionario 'dct' utilizando el método keys() e imprime cada clave
for key in dct.keys():
    print(key)

# Uso de la declaración for y el método values() para iterar sobre los valores del diccionario
# Itera sobre los valores del diccionario 'dct' utilizando el método values() e imprime cada valor
for value in dct.values():
    print(value)

# Uso de la declaración for y el método items() para iterar sobre los pares clave-valor del diccionario
# Itera sobre los pares clave-valor del diccionario 'dct' utilizando el método items() e imprime cada par
for key, value in dct.items():
    print(key, value)

#Copias    
    # Método 1: Usando el método copy()
    original_dict = {'a': 1, 'b': 2, 'c': 3}
    copied_dict = original_dict.copy()

    # Método 2: Usando el constructor dict()
    original_dict = {'a': 1, 'b': 2, 'c': 3}
    copied_dict = dict(original_dict)

# Unir diccionarios

# Diccionarios originales
# dct = {'name': 'Jennifer', 'age': 32, 'city': 'Cuenca', 'key4': 'value4'}
# dct2 = dict(name="Mary", age=27, city="Boston")

# Utilizando el método update() para unir los diccionarios. Las claves y valores del diccionario dct2 se añaden o actualizan en dct.
dct.update(dct2)

# Imprime el diccionario actualizado dct después de la unión, 
# las claves existentes en ambos el segundo diccionario sobreescribe los valores 
# y los pares que difieren en ambos no se guardan y desaparecen
print(dct)  # {'name': 'Mary', 'city': 'Boston', 'age': 27}

# También podemos crear un diccionario con claves numéricas 
my_dict = {3: 9, 6: 36, 9: 81}

print(my_dict)

# Para acceder a un valor en los diccionarios no podemos usar el indice (comentado para evitar un error)
# value = my_dict[0] # Error

# Si no la clave asociada en el diccionario 'my_dict' y lo asigna a la variable 'value'
value = my_dict[3]  # value será igual a 9

# Podemos usar una tupla como clave al ser inmutable, pero no podremos hacerlo con una lista
my_tuple = (8, 7)
my_dict = {my_tuple: 15}

print(my_dict)  # Output: {(8, 7): 15}