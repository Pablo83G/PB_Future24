
# JSON (JavaScript Object Notation) es un formato de datos liviano para el intercambio de datos.
# En Python tienes el módulo json incorporado para codificar y decodificar datos JSON. Simplemente impórtalo 
# y estarás listo para trabajar con datos JSON:

import json

# Algunas ventajas de JSON:
# - JSON existe como una "secuencia de bytes" que es muy útil en el caso de que necesitemos transmitir (stream) datos a través de una red.
# - En comparación con XML, JSON es mucho más pequeño, lo que se traduce en transferencias de datos más rápidas y mejores experiencias.
# - JSON es extremadamente amigable para los humanos ya que es textual y simultáneamente amigable para las máquinas.

# Formato JSON
"""
{
    "firstName": "Jane",
    "lastName": "Doe",
    "hobbies": ["running", "swimming", "singing"],
    "age": 28,
    "children": [
        {
            "firstName": "Alex",
            "age": 5
        },
        {
            "firstName": "Bob",
            "age": 7
        }
    ]
}
"""

# JSON admite tipos primitivos (cadenas, números, booleanos), así como matrices y objetos anidados. 
# Los objetos simples de Python se traducen a JSON de acuerdo con la siguiente conversión:

# Python	JSON
# dict	object
# list, tuple	array
# str	string
# int, long, float	number
# True	true
# False	false
# None	null

# De Python a JSON (Serialización, Codificación)
# Convierte objetos de Python en una cadena JSON con el método json.dumps().

person = {"name": "John", "age": 30, "city": "New York", "hasChildren": False, "titles": ["engineer", "programmer"]}

# convierte en JSON:
person_json = json.dumps(person)
# usa un estilo de formato diferente
person_json2 = json.dumps(person, indent=4, separators=("; ", "= "), sort_keys=True)

# el resultado es una cadena JSON:
print(person_json) 
print(person_json2) 
# {"name": "John", "age": 30, "city": "New York", "hasChildren": false, "titles":["engineer", "programmer"]}
# {
#     "age"= 30; 
#     "city"= "New York"; 
#     "hasChildren"= false; 
#     "name"= "John"; 
#     "titles"= [
#         "engineer"; 
#         "programmer"
#     ]
# }

# O convierte objetos de Python en objetos JSON y guárdalos en un archivo con el método json.dump().

person = {"name": "John", "age": 30, "city": "New York", "hasChildren": False, "titles": ["engineer", "programmer"]}

with open('person.json', 'w') as f:
    json.dump(person, f) # también puedes especificar la sangría, etc...

# De JSON a Python (Deserialización, Decodificación)
# Convierte una cadena JSON en un objeto Python con el método json.loads(). El resultado será un diccionario de Python.

person_json = """
{
    "age": 30, 
    "city": "New York",
    "hasChildren": false, 
    "name": "John",
    "titles": [
        "engineer",
        "programmer"
    ]
}
"""
person = json.loads(person_json)
print(person)
# {'age': 30, 'city': 'New York', 'hasChildren': False, 'name': 'John', 'titles': ['engineer', 'programmer']}

# O carga datos desde un archivo y conviértelos en un objeto Python con el método json.load().

with open('person.json', 'r') as f:
    person = json.load(f)
    print(person)
# {'name': 'John', 'age': 30, 'city': 'New York', 'hasChildren': False, 'titles': ['engineer', 'programmer']}

# Trabajando con Objetos Personalizados
# Codificación
# Codificar un objeto personalizado con JSONEncoder predeterminado generará un TypeError.
# Podemos especificar una función de codificación personalizada que almacenará el nombre de la clase 
# y todas las variables del objeto en un diccionario. Usa esta función para el argumento predeterminado en el método
# json.dump().

def encode_complex(z):
    if isinstance(z, complex):
        # solo la clave del nombre de la clase es importante, el valor puede ser arbitrario.
        return {z.__class__.__name__: True, "real":z.real, "imag":z.imag}
    else:
        raise TypeError(f"Object of type '{z.__class__.__name__}' is not JSON serializable")

z = 5 + 9j
zJSON = json.dumps(z, default=encode_complex)
print(zJSON)
# {"complex": true, "real": 5.0, "imag": 9.0}

# También puedes crear una clase de codificador personalizado y sobrescribir el método default(). 
# Usa esto para el argumento cls en el método json.dump(), o usa el codificador directamente.

from json import JSONEncoder

class ComplexEncoder(JSONEncoder):

    def default(self, o):
        if isinstance(z, complex):
            return {z

.__class__.__name__: True, "real":z.real, "imag":z.imag}
        # Deje que el método predeterminado de la clase base maneje otros objetos o genere un TypeError
        return JSONEncoder.default(self, o)

z = 5 + 9j
zJSON = json.dumps(z, cls=ComplexEncoder)
print(zJSON)
# o usa el codificador directamente:
zJson = ComplexEncoder().encode(z)
print(zJSON)
# {"complex": true, "real": 5.0, "imag": 9.0}
# {"complex": true, "real": 5.0, "imag": 9.0}

# Decodificación
# Decodificar un objeto personalizado con el JSONDecoder predeterminado es posible, 
# pero se decodificará en un diccionario. Escribe una función de decodificación personalizada que tome un 
# diccionario como entrada y cree tu objeto personalizado si puede encontrar el nombre de la clase del objeto 
# en el diccionario. Usa esta función para el argumento object_hook en el método json.load().

# Posible pero decodificado como un diccionario
z = json.loads(zJSON)
print(type(z))# <class 'dict'>
print(z)# {'complex': True, 'real': 5.0, 'imag': 9.0}

def decode_complex(dct):
    if complex.__name__ in dct:
        return complex(dct["real"], dct["imag"])
    return dct

# Ahora el objeto es de tipo complex después de la decodificación
z = json.loads(zJSON, object_hook=decode_complex)
print(type(z))# <class 'complex'>
print(z)# (5+9j)





# Funciones de plantilla de codificación y decodificación
# Esto funciona para todas las clases personalizadas si todas las variables de clase se proporcionan en el 
# método __init__.

class User:
    # Clase personalizada con todas las variables de clase dadas en el __init__()
    def __init__(self, name, age, active, balance, friends):
        self.name = name
        self.age = age
        self.active = active
        self.balance = balance
        self.friends = friends

class Player:
    # Otra clase personalizada
    def __init__(self, name, nickname, level):
        self.name = name
        self.nickname = nickname
        self.level = level


def encode_obj(obj):
    """
    Toma un objeto personalizado y devuelve una representación de diccionario del objeto.
    Esta representación de dict también incluye los nombres del módulo y la clase del objeto.
    """

    # Pobla el diccionario con metadatos del objeto
    obj_dict = {
      "__class__": obj.__class__.__name__,
      "__module__": obj.__module__
    }

    # Pobla el diccionario con las propiedades del objeto
    obj_dict.update(obj.__dict__)

    return obj_dict


def decode_dct(dct):
    """
    Toma un dict y devuelve un objeto personalizado asociado con el dict.
    Hace uso de los metadatos "__module__" y "__class__" en el diccionario
    para saber qué tipo de objeto crear.
    """
    if "__class__" in dct:
        # Pop se asegura de que eliminemos los metadatos del dict para dejar solo los argumentos de instancia
        class_name = dct.pop("__class__")

        # Obtiene el nombre del módulo del dict e impórtalo
        module_name = dct.pop("__module__")

        # Usamos la función __import__ incorporada ya que el nombre del módulo aún no se conoce en tiempo de ejecución
        module = __import__(module_name)

        # Obtiene la clase del módulo
        class_ = getattr(module,class_name)

        # Usa desempaquetado de diccionarios para inicializar el objeto
        # Nota: Esto solo funciona si todos los argumentos de __init__() de la clase son exactamente las claves del dict
        obj = class_(**dct)
    else:
        obj = dct
    return obj

# La clase Usuario funciona con nuestros métodos de codificación y decodificación
user = User(name = "John",age = 28, friends = ["Jane", "Tom"], balance = 20.70, active = True)

userJSON = json.dumps(user,default=encode_obj,indent=4, sort_keys=True)
print(userJSON)

user_decoded = json.loads(userJSON, object_hook=decode_dct)
print(type(user_decoded))

# La clase Jugador también funciona con nuestra codificación y decodificación personalizadas
player = Player('Max', 'max1234', 5)
playerJSON = json.dumps(player,default=encode_obj,indent=4, sort_keys=True)
print(playerJSON)

player_decoded = json.loads(playerJSON, object_hook=decode_dct)
print(type(player_decoded))
# {
#     "__class__": "User",
#     "__module__": "__main__",
#     "active": true,
#     "age": 28,
#     "balance": 20.7,
#     "friends": [
#         "Jane",
#         "Tom"
#     ],
#     "name": "John"
# }
# <class '__main__.User'>
# {
#     "__class__": "Player",
#     "__module__": "__main__",
#     "level": 5,
#     "name": "Max",
#     "nickname": "max1234"
# }
# <class '__main__.Player'>
