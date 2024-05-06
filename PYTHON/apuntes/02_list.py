
# Listas: ordenadas, mutables, permiten elementos duplicados
# Crear una lista dos formas:
mylist2 = list()
mylist = ["banana", "cherry", "apple", 5, True]

# Acceder a elementos
first_item = mylist[0]
last_item = mylist[-1]



# Iterar sobre una lista
for item in mylist:
    print(item)

# Funciones dentro de un bucle
my_list_num = [1, 2, 3, 4, 5, 6]
# Utilizamos una expresión de lista con una función para calcular el cuadrado de cada número en my_list_num
list_square_num = [i*i for i in my_list_num]
print(list_square_num)  # Imprime los cuadrados de los números en my_list_num

# Verificar si un elemento está en la lista
if "banana" in mylist:
    print("Sí")
else:
    print("No")

# Longitud de la lista
print(len(mylist))

# Invertir la lista
mylist.reverse()
print(mylist)


# Añadir un elemento al final de la lista
mylist.append("lemon")

# Insertar un elemento en una posición específica
mylist.insert(1, "blueberry")

# Eliminar y obtener el último elemento de la lista
item = mylist.pop()
print(item)
print(mylist)

# Eliminar un elemento específico de la lista
mylist.remove("cherry")
print(mylist)

# Eliminar todos los elementos de la lista
mylist.clear()


# Usando sort() para ordenar la lista original
my_number_list = [3, 1, 7, -4, 2]
my_number_list.sort()
print("Lista ordenada con sort():", my_number_list)  # Imprime la lista original, ahora ordenada

# Usando sorted() para obtener una nueva lista ordenada
sorted_list = sorted(my_number_list)
print("Nueva lista ordenada con sorted():", sorted_list)  # Imprime la nueva lista ordenada
print("Lista original no modificada:", my_number_list)  # Imprime la lista original, que permanece inalterada


# Copiar una lista
mylist_copy = my_number_list.copy()
print(mylist_copy)

# Contar la ocurrencia de un elemento en la lista
count = mylist_copy.count(3)
print(count)

# Extender una lista con otra lista
mylist.extend(["orange", "grape"])
print(mylist)

# Nueva asignación de mylist que crea una lista con cinco elementos, todos iguales a 0.
my_new_list = [0] * 5
print(my_new_list)

# Unir listas
together_list = mylist + my_number_list
print(together_list)

# slicing en Python. 
# El "slicing" se utiliza para crear una subsecuencia de una lista, tupla, o cualquier otro tipo de secuencia en Python.
my_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
a = my_list[::1]  # Aquí, la notación [::1] esto significa que se toman todos los elementos de la lista en el mismo orden en que están.
                  # Por lo tanto, 'a' será una copia exacta de 'my_list'.
print(a)

b = my_list[::2]  # La notación [::2] esto significa que se toma el primer elemento, se omite el segundo, se toma el tercero, y así sucesivamente.
                  # Por lo tanto, 'b' será una lista que contiene solo los elementos en posiciones impares de 'my_list'.
print(b)

c = my_list[::-1]  # La notación [::-1] esto significa que se toman todos los elementos de la lista, pero en orden inverso
                  
print(c)

# Copiar una lista
original_list = [1, 2, [3, 4]]

# Copia mediante slicing
copied_list1 = original_list[:]

# Copia mediante el método copy()
copied_list2 = original_list.copy()

# Copia mediante la función list()
copied_list3 = list(original_list)


# Modificamos la lista original
original_list[0] = 5
original_list[2][0] = 6

print("Original:", original_list)
print("Copia (slicing):", copied_list1)
print("Copia (método copy()):", copied_list2)
print("Copia (función list()):", copied_list3)

