import csv 
import random
from datetime import datetime
import uuid
import pandas as pd
from os import path

class Hangman:
    def __init__(self):
        self.words=[]
        self.current_word=""
        self.tries = 0
        self.max_tries = 6
        self.guessed_letters = set()
        self.rounds = 3
        self.score = 0
        self.displayed_word=""
        self.victory=""
        self.id=""
        self.username=""
        self.start=""
        self.end=""
    #Función que lee el fichero words y carga las palabras
    def load(self, filename):
        try:
            #Leemos el fichero y cargamos los datos en la propiedad de la clase words
            with open(filename, 'r', encoding='utf-8') as csvfile:
                reader = csv.reader(csvfile)
                for row in reader:
                    self.words.append(row[0].upper().strip()) #como las palabras están en la primera columna, usamos el indice 0
                                                                # ponemos las palabras en mayusculas y quitamos los espacios que puedan tener
        except FileNotFoundError:
            print("El archivo no se ha encontrado")
     
    #Función que comprueba que se hayan cargado las 30 palabras como requisito para iniciar el juego       
    def get_number_of_words(self):
        if len(self.words) == 30:
            return True
        else:
            return False
    
    #Función que selecciona una palabra    
    def chose_word(self):
        self.current_word=random.choice(self.words)
        self.words.remove(self.current_word)#quitamos la palabra de la lista para evitar que se vuelva a escoger en la misma partida
        # print(self.current_word)
    
    #Función que muestra los espacios o las letras en su posición     
    def display_word(self):
        # Inicializamos una cadena vacía para almacenar la representación de la palabra a mostrar
        self.displayed_word = ""
        # Iteramos sobre cada letra de la palabra actual
        for letter in self.current_word: 
            # Verificamos si la letra ha sido adivinada por el jugador
            if letter in self.guessed_letters:
                # Si la letra ha sido adivinada, la añadimos a la cadena de la palabra mostrada
                self.displayed_word += letter + " "
            else:
                # Si la letra no ha sido adivinada, la sustituimos por un guion bajo
                self.displayed_word += "_ "
        # Imprimimos la palabra mostrada en la consola
        print(self.displayed_word)

        
    #Funcion que muestra los diferentes estados del ahorcado    
    def display_hangman(self):
        # Definimos una lista 
        gallow=[
             """
            +-------+
            |       
            |
            |
            |
            ==========
            """,
            """
            +-------+
            |       |
            |
            |
            |
            ==========
            """,
            """
            +-------+
            |       |
            |       O
            |
            |
            ==========
            """,
            """
            +-------+
            |       |
            |       O
            |      \\|
            |
            ==========
            """,
            """
            +-------+
            |       |
            |       O
            |      \\|/
            |
            ==========
            """,
            """
            +-------+
            |       |
            |       O
            |      \\|/
            |      /
            ==========
            """,
            """
            +-------+
            |       |
            |       O
            |      \\|/
            |      / \\
            ==========
            """
        ]
        #Según el numero de intentos que tenga la ronda se imprimirá un estado diferente
        print(gallow[self.tries])
    
    #Función que genera el id de la partida            
    def generate_game_id(self):
        self.id=uuid.uuid4()            
     
    #Función que establece la fecha y hora de inicio de la partida        
    def start_date(self):
        self.start=datetime.now()
        
    #Función que establece la fecha y hora de fin de la partida  
    def end_date(self):
        self.end=datetime.now()
        
    
    # Función que registra los datos de la partida 
    def register_game(self,file_path): 
        
        df=pd.DataFrame({
                        'game_id':[self.id],
                        'username':[self.username],
                        'start_date':[self.start],
                        'end_date':[self.end],
                        'final_score':[self.score]
                        })
        
        # Verificamos si el archivo existe y tiene contenido antes de decidir añadir encabezados
        if path.exists(file_path) and path.getsize(file_path) > 0:
            # Añadimos datos sin encabezados
            df.to_csv(file_path, mode='a', header=False, index=False)
        else:
            # Creamos archivo nuevo con encabezados
            df.to_csv(file_path, mode='w', header=True, index=False)

        print("Partida registrada correctamente.")
        
    # Función que registra los datos de la ronda                   
    def register_round(self,file_path):
            # Crea DataFrame con los datos de la ronda
        df = pd.DataFrame({
            "game_id": [self.id],
            "word": [self.current_word],
            "username": [self.username],
            "round_id": [self.current_round],
            "user_tries": [self.tries],
            "victory": [self.victory]
        })
        
        # Verificamos si el archivo existe y tiene contenido antes de decidir añadir encabezados
        if path.exists(file_path) and path.getsize(file_path) > 0:
            # Añadir datos sin encabezados
            df.to_csv(file_path, mode='a', header=False, index=False)
        else:
            # Crear archivo nuevo con encabezados
            df.to_csv(file_path, mode='w', header=True, index=False)

        print("Ronda registrada correctamente.")
        

    #Función para ejecutar una ronda        
    def play_round(self):
       #Inicializamos los valores para cada ronda (intentos y letras dadas)
       self.tries=0
       self.guessed_letters = set()
       self.victory=""   
       self.chose_word() #Escogemos una palabra para que el jugador la adivine
        
       #Bucle principal de la ronda
       while True:
           # Mostramos el estado del ahorado y el numero de letras adivinadas
           self.display_hangman()
           self.display_word()
           
           # Comprueba si se ha adivinado la palabra
           if "_ " not in self.displayed_word:
               print("¡Felicidades, has adivinado la palabra!")
               self.victory=True
               self.score+=1 # Aumentamos la puntuación del jugador por adivinar la palabra
               break  # Sale del bucle ya que se ha adivinado la palabra
           
           #Mediante la función difference extraemos las letras erróneas 
           error_letters=self.guessed_letters.difference(set(self.current_word)) 
           if error_letters:
                print(f"Letras erróneas: {error_letters}") #Si ya ha fallado alguna letra se mostrarán
                 
           #Solicitamos una nueva letra (la convertimos a mayuscula) y se agrega al conjunto 
           guess=input("Introduce una letra: ").upper()
           self.guessed_letters.add(guess)    
           
           # comprueba que la letra dada no este en la palabra secreta
           if guess not in self.current_word:
               self.tries+=1 # Aumenta en uno el numero de intentos
               print("¡Fallo!")   
               
               # Verifica si se han agotado los intentos permitidos
               if self.tries >= self.max_tries:
                    self.display_hangman()
                    print("Lo siento, has agotado todos tus intentos. La palabra era:", self.current_word)
                    self.victory=False
                    break # Sale del bucle ya que se han agotado los intentos
           else:
               # La letra introducida está en la palabra
                print("¡Acierto!")        
        
    
        
    #Función que ejecuta el juego          
    def play(self):
        self.id=""
        self.username=""
        self.start=""
        self.end=""
        self.current_round=0
        # Comprueba que las 30 palabras estén cargadas en la propiedad de la clase para iniciar el juego
        if(self.get_number_of_words()):
            print("Bienvinid@ al juego del ahorcado")
            
            self.generate_game_id()
            self.start_date()
            
            #Solicitamos el nombre del jugador:
            self.username = input("Por favor, introduce tu nombre de usuario: ")
            print(f"Comencemos, {self.username}!")
            
            # Bucle que llamará a la función ronda tantas veces como rondas haya definidas en la propiedad self.rounds
            for round in range(self.rounds):
                self.current_round=round+1
                print(f"Ronda {self.current_round}")
                self.play_round()
                self.register_round('./files/rounds_in_games.csv')
                
            # Muestra la puntuación final del jugador al finalizar todas las rondas    
            print(f"Fin de la partida, {self.username} tu puntuación ha sido de {self.score}")
            
            #Registramos la fecha de finalización
            self.end_date()
            
            #Registramos los datos de la partida en el fichero games.csv
            self.register_game('./files/games.csv')
        else: 
            print("Vaya, parece que no encontramos todas las palabras necesarias, no podemos dar comienzo al juego")