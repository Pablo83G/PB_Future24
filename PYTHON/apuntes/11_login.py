
# El módulo de registro en Python es un módulo incorporado potente que te permite agregar rápidamente registro a tu aplicación.
import logging

# Nivel de registro
# Hay 5 niveles de registro diferentes que indican la gravedad de los eventos. 
# Por defecto, el sistema registra solo eventos con nivel WARNING y superior.

import logging
logging.debug('Este es un mensaje de depuración')
logging.info('Este es un mensaje de información')
logging.warning('Este es un mensaje de advertencia')
logging.error('Este es un mensaje de error')
logging.critical('Este es un mensaje crítico')

"""
Configuración
Con basicConfig(**kwargs) puedes personalizar el registro raíz. 
Los parámetros más comunes son el nivel, el formato y el nombre del archivo.

Ver https://docs.python.org/3/library/logging.html#logging.basicConfig para todos los argumentos posibles.
Ver también https://docs.python.org/3/library/logging.html#logrecord-attributes para formatos posibles y
https://docs.python.org/3/library/time.html#time.strftime cómo configurar la cadena de tiempo.

Ten en cuenta que esta función solo debe llamarse una vez, y típicamente lo primero después de importar el módulo. 
No tiene efecto si el registro raíz ya tiene controladores configurados.
Por ejemplo, llamar a logging.info(...) antes del basicConfig ya establecerá un controlador.
"""
import logging
logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(name)s - %(levelname)s - %(message)s', datefmt='%m/%d/%Y %H:%M:%S')
# Ahora también los mensajes de depuración se registrarán con un formato diferente.
logging.debug('Mensaje de depuración')

# Esto registraría en un archivo en lugar de en la consola.
# logging.basicConfig(level=logging.DEBUG, filename='app.log')

"""
# Registro en módulos y jerarquía de registros
# La mejor práctica en tu aplicación con múltiples módulos es crear un registro interno usando la variable global __name__.
# Esto creará un registro con el nombre de tu módulo y garantizará que no haya colisiones de nombres.
# El módulo de registro crea una jerarquía de registradores, comenzando con el registro raíz, y agregando el nuevo registro a esta jerarquía.
# Si luego importas tu módulo en otro módulo, los mensajes de registro pueden estar asociados con el módulo correcto a través del nombre del registrador.
# Ten en cuenta que cambiar la configuración básica del registro raíz también afectará a los eventos de registro de los otros (inferiores) registradores en la jerarquía.
"""
# helper.py
# -------------------------------------
import logging
logger = logging.getLogger(__name__)
logger.info('HELLO')

# main.py
# -------------------------------------
import logging
logging.basicConfig(level=logging.INFO, format='%(name)s - %(levelname)s - %(message)s')
"""import helper"""

# --> Salida al ejecutar main.py
# helper - INFO - HELLO
"""
# Propagación
# Por defecto, todos los registradores creados pasarán los eventos de registro a los controladores de los registradores superiores, 
# además de cualquier controlador adjunto al registrador creado.
# Puedes desactivar esto configurando propagate = False. A veces, cuando te preguntas por qué no ves mensajes de registro de otro módulo,
# esta propiedad puede ser la razón.
"""
# helper.py
# -------------------------------------
import logging
logger = logging.getLogger(__name__)
logger.propagate = False
logger.info('HELLO')

# main.py
# -------------------------------------
import logging
logging.basicConfig(level=logging.INFO, format='%(name)s - %(levelname)s - %(message)s')
"""import helper"""

# --> No hay salida al ejecutar main.py ya que el registrador del módulo helper no propaga sus mensajes al registrador raíz
"""
# Controladores de registro
# Los objetos de controlador son responsables de enviar los mensajes de registro apropiados al destino específico del controlador.
# Por ejemplo, puedes usar diferentes controladores para enviar mensajes de registro al flujo de salida estándar, a archivos, a través de 
# HTTP o por correo electrónico.
# Típicamente, configuras cada controlador con un nivel (setLevel()), un formateador (setFormatter()) y opcionalmente un filtro (addFilter()).
# Ver https://docs.python.org/3/howto/logging.html#useful-handlers para posibles controladores incorporados.
# Por supuesto, también puedes implementar tus propios controladores derivando de estas clases.
"""
import logging

logger = logging.getLogger(__name__)

# Crea los controladores
stream_handler = logging.StreamHandler()
file_handler = logging.FileHandler('file.log')

# Configura el nivel y el formateador y añádelo a los controladores
stream_handler.setLevel(logging.WARNING) # warning y superior se registran en el flujo
file_handler.setLevel(logging.ERROR) # error y superior se registran en un archivo

stream_format = logging.Formatter('%(name)s - %(levelname)s - %(message)s')
file_format = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
stream_handler.setFormatter(stream_format)
file_handler.setFormatter(file_format)

# Añade los controladores al registrador
logger.addHandler(stream_handler)
logger.addHandler(file_handler)

logger.warning('Este es un mensaje de advertencia') # registrado en el flujo
logger.error('Este es un error') # registrado en el flujo Y en el archivo!

# Ejemplo de un filtro
class InfoFilter(logging.Filter):

    # sobreescribe este método. Solo los registros de registro para los cuales esta
    # función se evalúa como Verdadera pasarán el filtro.
    def filter(self, record):
        return record.levelno == logging.INFO

# Ahora solo se registrarán los mensajes de nivel INFO
stream_handler.addFilter(InfoFilter())
logger.addHandler(stream_handler)
"""
# Otros métodos de configuración
# Hemos visto cómo configurar el registro creando registradores, controladores y formateadores explícitamente en el código.
# Hay otros dos métodos de configuración: 
# - Crear un archivo de configuración de registro y leerlo utilizando la función fileConfig(). Ver el ejemplo a continuación.
# - Crear un diccionario de información de configuración y pasarlo a la función dictConfig(). Ver https://docs.python.org/3/library/logging.config.html#logging.config.dictConfig para más información.

# Archivo .conf
# Crea un archivo .conf (o a veces almacenado como .ini), define los registradores, controladores y formateadores y proporciona los nombres como claves.
# Después de que se definan sus nombres, se configurarán agregando las palabras logger, handler y formatter antes de sus nombres separados por un guion bajo.
# Luego puedes configurar las propiedades para cada registrador, controlador y formateador.
# En el siguiente ejemplo, el registro raíz y un registrador llamado simpleExample se configurarán con un StreamHandler.
"""
# logging.conf
#[loggers]
#keys=root,simpleExample

#[handlers]
#keys=consoleHandler

#[formatters]
#keys=simpleFormatter

#[logger_root]
#level=DEBUG
#handlers=consoleHandler

#[logger_simpleExample]
#level=DEBUG
#handlers=consoleHandler
#qualname=simpleExample
#propagate=0

#[handler_consoleHandler]
#class=StreamHandler
#level=DEBUG
#formatter=simpleFormatter
#args=(sys.stdout,)

#[formatter_simpleFormatter]
#format=%(asctime)s - %(name)s - %(levelname)s - %(message)s

# Luego usa el archivo de configuración en el código
import logging
import logging.config

logging.config.fileConfig('logging.conf')

# crea un registrador con el nombre del archivo de configuración.
# Este registrador ahora tiene un StreamHandler con nivel DEBUG y el formato especificado
logger = logging.getLogger('simpleExample')

logger.debug('mensaje de depuración')
"""
# Captura de trazas de pila
# Registrar el traceback en tus registros de excepción puede ser muy útil para solucionar problemas.
# Puedes capturar el traceback en logging.error() configurando el parámetro exc_info en True.
"""
import logging

try:
    a = [1, 2, 3]
    value = a[3]
except IndexError as e:
    logging.error(e)
    logging.error(e, exc_info=True)
# Salida:
# ERROR:root:list index out of range
# ERROR:root:list index out of range
# Traceback (most recent call last):
#   File "<ipython-input-6-df97a133cbe6>", line 5, in <module>
#     value = a[3]
# IndexError: list index out of range

# Si no capturas la excepción correcta, también puedes usar el método traceback.format_exc() para registrar la excepción.

import logging
import traceback

try:
    a = [1, 2, 3]
    value = a[3]
except:
    logging.error("excepción no capturada: %s", traceback.format_exc())
"""
# Rotating FileHandler
# Cuando tienes una aplicación grande que registra muchos eventos en un archivo, y solo necesitas realizar un seguimiento de los eventos más recientes, entonces usa un RotatingFileHandler que mantiene los archivos pequeños.
# Cuando el registro alcanza cierto número de bytes, se "recoge". También puedes mantener varios archivos de registro de respaldo antes de sobrescribirlos.
"""
import logging
from logging.handlers import RotatingFileHandler

logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

# se recoge después de 2KB y se mantienen registros de respaldo app.log.1, app.log.2 , etc.
handler = RotatingFileHandler('app.log', maxBytes=2000, backupCount=5)
logger.addHandler(handler)

for _ in range(10000):
    logger.info('Hola, mundo!')
"""
# TimedRotatingFileHandler
# Si tu aplicación se ejecutará durante mucho tiempo, puedes usar un TimedRotatingFileHandler. Esto creará un registro rotativo basado en cuánto tiempo ha pasado.
# Las condiciones de tiempo posibles para el parámetro when son:
# - segundo (s)
# - minuto (m)
# - hora (h)
# - día (d)
# - w0-w6 (día de la semana, 0=lunes)
# - medianoche
"""
import logging
import time
from logging.handlers import TimedRotatingFileHandler

logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

# Esto creará un nuevo archivo de registro cada minuto y 5 archivos de respaldo con una marca de tiempo antes de sobrescribir los viejos registros.
handler = TimedRotatingFileHandler('timed_test.log', when='m', interval=1, backupCount=5)
logger.addHandler(handler)

for i in range(6):
    logger.info('Hola, mundo!')
    time.sleep(50)
"""
# Registro en formato JSON
# Si tu aplicación genera muchos registros de diferentes módulos, y especialmente en una arquitectura de microservicios, puede ser difícil localizar los registros importantes para tu análisis.
# Por lo tanto, es una buena práctica registrar tus mensajes en formato JSON y enviarlos a un sistema de gestión de registros centralizado.
# Entonces puedes buscar, visualizar y analizar fácilmente tus registros.
# Recomiendo usar este registrador JSON de código abierto: https://github.com/madzak/python-json-logger
# pip install python-json-logger
"""
import logging
# from pythonjsonlogger import jsonlogger

logger = logging.getLogger()

logHandler = logging.StreamHandler()
formatter = jsonlogger.JsonFormatter()
logHandler.setFormatter(formatter)
logger.addHandler(logHandler)
