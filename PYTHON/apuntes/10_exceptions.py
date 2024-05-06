
# Un programa de Python termina tan pronto como encuentra un error. En Python, un error puede ser un error de sintaxis o una excepción.
# En este artículo veremos:
# - Error de sintaxis vs. Excepción
# - Cómo lanzar excepciones
# - Cómo manejar excepciones
# - Excepciones incorporadas más comunes
# - Cómo definir tu propia excepción

# Error de sintaxis
# Un Error de sintaxis ocurre cuando el analizador detecta una declaración sintácticamente incorrecta.
# Un error de sintaxis puede ser, por ejemplo, un error tipográfico, paréntesis faltantes, sin nueva línea (ver código abajo),
# o mala indentación (esto en realidad generará su propio IndentationError, pero es una subclase de SyntaxError).

a = 5 print(a)
# Salida:
#   File "<ipython-input-5-fed4b61d14cd>", line 1
#     a = 5 print(a)
#               ^
# SyntaxError: invalid syntax

# Excepciones
# Incluso si una declaración es sintácticamente correcta, puede causar un error cuando se ejecuta. Esto se llama un error de excepción.
# Hay varias clases de errores diferentes, por ejemplo, tratar de sumar un número y una cadena generará un TypeError.

a = 5 + '10'
# Salida:
# TypeError: unsupported operand type(s) for +: 'int' and 'str'

# Lanzar una excepción
# Si quieres forzar que ocurra una excepción cuando se cumpla una cierta condición, puedes usar la palabra clave raise.

x = -5
if x < 0:
    raise Exception('x no debería ser negativo.')
# Salida:
# Exception: x should not be negative.

# También puedes usar la declaración assert, que lanzará un AssertionError si tu afirmación no es Verdadera.
# De esta manera, puedes probar activamente algunas condiciones que deben cumplirse en lugar de esperar a que tu programa se bloquee 
# inesperadamente a la mitad.
# La afirmación también se usa en las pruebas unitarias.

x = -5
assert (x >= 0), 'x no es positivo.'
# --> Tu código funcionará bien si x >= 0
# Salida:
# AssertionError: x is not positive.

# Manejo de excepciones
# Puedes usar un bloque try y except para atrapar y manejar excepciones. Si puedes atrapar excepciones, tu programa no terminará y puede continuar.

# Esto atrapará todas las excepciones posibles
try:
    a = 5 / 0
except:
    print('ocurrió algún error.')

# También puedes atrapar el tipo de excepción
try:
    a = 5 / 0
except Exception as e:
    print(e)# division by zero

# Es una buena práctica especificar el tipo de excepción que quieres atrapar.
# Por lo tanto, tienes que conocer los errores posibles
try:
    a = 5 / 0
except ZeroDivisionError:
    print('Solo se maneja un ZeroDivisionError aquí')

# Puedes ejecutar múltiples declaraciones en un bloque try, y atrapar diferentes excepciones posibles
try:
    a = 5 / 1 # Nota: No hay ZeroDivisionError aquí
    b = a + '10'
except ZeroDivisionError as e:
    print('Ocurrió un ZeroDivisionError:', e)
except TypeError as e:
    print('Ocurrió un TypeError:', e)# Ocurrió un TypeError: unsupported operand type(s) for +: 'float' and 'str'






# Clausula else
# Puedes usar una declaración else que se ejecutará si no ocurrió ninguna excepción.

try:
    a = 5 / 1
except ZeroDivisionError as e:
    print('Ocurrió un ZeroDivisionError:', e)
else:
    print('Todo está bien')
# Salida:
# Todo está bien

# Clausula finally
# Puedes usar una declaración finally que siempre se ejecuta, independientemente de si hubo una excepción o no.
# Esto se usa, por ejemplo, para realizar algunas operaciones de limpieza.

try:
    a = 5 / 1 # Nota: No hay ZeroDivisionError aquí
    b = a + '10'
except ZeroDivisionError as e:
    print('Ocurrió un ZeroDivisionError:', e)
except TypeError as e:
    print('Ocurrió un TypeError:', e)
else:
    print('Todo está bien')
finally:
    print('Limpiando algunas cosas...')
# Salida:
# A TypeError occured: unsupported operand type(s) for +: 'float' and 'str'
# Limpiando algunas cosas...

# Excepciones incorporadas comunes
# Puedes encontrar todas las excepciones incorporadas aquí: https://docs.python.org/3/library/exceptions.html
# - ImportError: Si un módulo no puede ser importado
# - NameError: Si intentas usar una variable que no fue definida
# - FileNotFoundError: Si intentas abrir un archivo que no existe o especificas la ruta incorrecta
# - ValueError: Cuando una operación o función recibe un argumento que tiene el tipo correcto pero un valor inapropiado,
#   por ejemplo, intentar eliminar un valor de una lista que no existe
# - TypeError: Se genera cuando se aplica una operación o función a un objeto de tipo inapropiado.
# - IndexError: Si intentas acceder a un índice inválido de una secuencia, por ejemplo, una lista o una tupla.
# - KeyError: Si intentas acceder a una clave que no existe de un diccionario.

# ImportError
import nonexistingmodule

# NameError
a = someundefinedvariable

# FileNotFoundError
with open('nonexistingfile.txt') as f:
    read_data = f.read()

# ValueError
a = [0, 1, 2]
a.remove(3)

# TypeError
a = 5 + "10"

# IndexError
a = [0, 1, 2]
value = a[5]

# KeyError
my_dict = {"name": "Max", "city": "Boston"}
age = my_dict["age"]

# Definir tus propias excepciones
# Puedes definir tu propia clase de excepción que debe derivarse de la clase Exception incorporada.
# La mayoría de las excepciones se definen con nombres que terminan en 'Error', similar a la nomenclatura de las excepciones estándar.
# Las clases de excepción se pueden definir como cualquier otra clase, pero generalmente se mantienen simples, a menudo solo ofreciendo
# una serie de atributos que permiten extraer información sobre el error mediante controladores.

# Ejemplo mínimo para la propia clase de excepción
class ValueTooHighError(Exception):
    pass

# o añade más información


class ValueTooLowError(Exception):
    def __init__(self, message, value):
        self.message = message
        self.value = value

def test_value(a):
    if a > 1000:
        raise ValueTooHighError('El valor es demasiado alto.')
    if a < 5:
        raise ValueTooLowError('El valor es demasiado bajo.', a) # Observa que el constructor toma 2 argumentos aquí
    return a

try:
    test_value(1)
except ValueTooHighError as e:
    print(e)
except ValueTooLowError as e:
    print(e.message, 'El valor es:', e.value)
# Salida:
# El valor es demasiado bajo. El valor es: 1
