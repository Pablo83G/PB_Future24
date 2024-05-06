
# Una cadena es una secuencia de caracteres. 
# Los literales de cadena en Python están encerrados por comillas simples o dobles.
# Las cadenas en Python son inmutables, lo que significa que no pueden cambiarse después de ser creadas.

mi_cadena = 'Hola'

# Uso de comillas simples o dobles
mi_cadena = 'Hello'
mi_cadena = "Hello"
mi_cadena = "I' m  a 'Geek'"

# Escapando con barra invertida
mi_cadena = 'I\' m  a "Geek"'
mi_cadena = 'I\' m a \'Geek\''
print(mi_cadena)# I' m a 'Geek'

# Comillas triples para cadenas multilinea
mi_cadena = """Hello
World"""
print(mi_cadena)# Hello
                # World


# Barra invertida si quieres continuar en la próxima línea.
# La barra invertida se interpreta como un indicador de que la cadena se continúa en la próxima línea en el código fuente,
# pero no afecta cómo se muestra la cadena cuando se imprime. 

mi_cadena = "Hello \
World"
print(mi_cadena) # Hello World


# Acceder a caracteres y subcadenas
mi_cadena = "Hello World"

# Obtener un carácter referenciando el índice
b = mi_cadena[0]
print(b)  # H

# Subcadenas con slicing
b = mi_cadena[1:3] # Nota que el último índice no está incluido
print(b) # el
b = mi_cadena[:5] # desde el principio
print(b) # Hello
b = mi_cadena[6:] # hasta el final
print(b) # World
b = mi_cadena[::2] # del principio al final con cada segundo ítem
print(b) # HloWrd
b = mi_cadena[::-1] # invertir la cadena con un paso negativo:
print(b) # dlroW olleH


# Concatenar dos o más cadenas
# concatenar cadenas con +
saludo = "Hello"
nombre = "Tom"
frase = saludo + ' ' + nombre
print(frase) # Hello Tom

# Iterar
# Iterar sobre una cadena usando un bucle for
mi_cadena = 'Hello'
for i in mi_cadena:
    print(i)
# H
# e
# l
# l
# o


# Comprobar si un carácter o subcadena existe
if "a" in "Hello":
    print("yes") 
else:
    print("no")# no
if "llo" in "Hello":
    print("yes")  # yes




# Métodos útiles
mi_cadena = "     Hello World "

# quitar espacios en blanco, como los string son inmutables la función no alterará la cadena original
# a no ser que la asignemos el valor de nuevo a la cadena 
mi_cadena = mi_cadena.strip()
print(mi_cadena)# Hello World

# número de caracteres

# Mayúsculas y minúsculas
print(mi_cadena.upper())    # HELLO WORLD

print(mi_cadena.lower())    # hello world

# startswith y endswith
print("hello".startswith("he")) # True
print("hello".endswith("llo"))  # True


# encontrar el primer índice de una subcadena dada, -1 en caso contrario
print("Hello".find("o"))    # 4

# contar el número de caracteres/subcadenas
print("Hello".count("e"))   # 1


# reemplazar una subcadena con otra cadena (solo si se encuentra la subcadena)
# Nota: La cadena original permanece igual
mensaje = "Hello World"
nuevo_mensaje = mensaje.replace("World", "Universe")
print(nuevo_mensaje)    # Hello Universe

################### 1:11:04
# dividir la cadena en una lista
mi_cadena = "how are you doing"
a = mi_cadena.split() # el argumento predeterminado es " "
print(a)    # ['how', 'are', 'you', 'doing']

mi_cadena = "one,two,three"
a = mi_cadena.split(",")
print(a)    # ['one', 'two', 'three']

# unir elementos de una lista en una cadena
mi_lista = ['How', 'are', 'you', 'doing']
a = ' '.join(mi_lista) # la cadena dada es el separador, por ejemplo, ' ' entre cada argumento
print(a)





# Formato¶
# El nuevo estilo es con .format() y el antiguo estilo es con el operador %.

# usar llaves como marcadores de posición
a = "Hello {0} and {1}".format("Bob", "Tom")
print(a)

# las posiciones son opcionales para el orden predeterminado
a = "Hello {} and {}".format("Bob", "Tom")
print(a)

a = "El valor entero es {}".format(2)
print(a)

# algunas reglas de formato especiales para números
a = "El valor flotante es {0:.3f}".format(2.1234)
print(a)
a = "El valor flotante es {0:e}".format(2.1234)
print(a)
a = "El valor binario es {0:b}".format(2)
print(a)

# formato antiguo utilizando el operador %
print("Hello %s and %s" % ("Bob", "Tom")) # debe ser una tupla para múltiples argumentos
val =  3.141592653
59
print("The decimal value is %d" % val)
print("The float value is %f" % val)
print("The float value is %.2f" % val)
# Hello Bob and Tom
# The decimal value is 3
# The float value is 3.141593
# The float value is 3.14
# f-Strings¶
# Nuevo desde Python 3.6. Utiliza las variables directamente dentro de las llaves.

nombre = "Eric"
edad = 25
a = f"Hello, {nombre}. You are {edad}."
print(a)
pi = 3.14159
a = f"Pi is {pi:.3f}"
print(a)
# Las f-Strings se evalúan en tiempo de ejecución, lo que permite expresiones
a = f"The value is {2*60}"
print(a)
# Hello, Eric. You are 25.
# Pi is 3.142
# The value is 120
# Más sobre inmutabilidad y concatenación¶
# dado que una cadena es inmutable, agregar cadenas con + o += siempre
# crea una nueva cadena, y por lo tanto es costoso para múltiples operaciones
# --> el método join es mucho más rápido
from timeit import default_timer as timer
mi_lista = ["a"] * 1000000

# mal
inicio = timer()
a = ""
for i in mi_lista:
    a += i
fin = timer()
print("concatenate string with + : %.5f" % (fin - inicio))

# bien
inicio = timer()
a = "".join(mi_lista)
fin = timer()
print("concatenate string with join(): %.5f" % (fin - inicio))
# concatenate string with + : 0.34527
# concatenate string with join(): 0.01191
