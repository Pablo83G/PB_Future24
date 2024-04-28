<<<<<<< HEAD
package com.cleanCode.CCJen.ejercicio6;

import java.util.*;

public class Mastermind {
    private static final List<String> AVAILABLE_COLOURS = Arrays.asList("AZUL","ROJO","VERDE","AMARILLO");
    private static final int ATTEMPTS =10;
    private List<String> sequence;

    /**
     * Constructor de la clase. Depende del @method generarSecuencia para crear la secuencia aleatoria de colores a adivinar.
     */
    public Mastermind() {
        this.sequence = generarSecuencia();
    }


    /**
     * Genera la secuencia aleatoria de 4 colores disponibles en la lista AVAILABLE_COLORS
     * @return  La secuencia aleatoria generada.
     */
    private List<String> generarSecuencia(){
        List<String> sequence= new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<4; i++){
            sequence.add(AVAILABLE_COLOURS.get(random.nextInt(AVAILABLE_COLOURS.size())));
        }
        return sequence;
    }


    /**
     * Permite obtener la respuesta del jugador, controlando que la respuesta se ajuste a los colores disponibles
     * @return La secuencia de colores dada por el jugador
     */
    private List<String> obtenerIntentoJugador() {

        Scanner scanner = new Scanner(System.in);
        List<String> intento = new ArrayList<>();
        for( int i=0; i<4;i++){
            System.out.print("Ingresa el color #"+(i+1)+": ");
            String color = scanner.nextLine().toUpperCase();
            while(!AVAILABLE_COLOURS.contains(color)){
                System.out.println("Color no valido. Ingresa uno de los siguientes colores (Azul,Rojo,Verde o Amarillo)");
                color = scanner.nextLine().toUpperCase();;
            }
                intento.add(color);
        }
        return intento;
    }

    /**
     * Verifica si el intento del jugador coincide con la secuencia final que se ha generado al inicio
     * @param intentoJugador La secuencia de colores dada por el jugador
     * @return El resultado del intento (Blanca=> color y posicion correcta,
     *                                   Negra => color correcto pero posición incorrecta,
     *                                   ? => el color no se encuentra en la lista generada.
     */
    private List<String> procesarIntento(List<String> intentoJugador) {
        List<String> resultado = new ArrayList<>();

        for (int i = 0; i < sequence.size(); i++) {
            String colorSecuencia = sequence.get(i);
            String colorIntento = intentoJugador.get(i);
            if (colorSecuencia.equals(colorIntento)) {
                resultado.add("Blanca");
            } else if (sequence.contains(colorIntento)) {
                resultado.add("Negra");
            } else {
                resultado.add("?");
            }
        }

        return resultado;
    }

    /**
     * Muestra el resultado del intento del jugador tras la verificacion
     * @param resultado El resultado generado por el metodo procesarItento
     */
    private void mostrarResultado(List<String> resultado) {
        System.out.println("Resultado: " + resultado);
    }

    /**
     * Método que comprueba que la respuesta del usuario es correcta = todos los elementos del resultado son "Blanca"
     * @param resultado El resultado generado por el metodo procesarItento
     * @return true si la secuencia es correcta
     *          false de lo contrario.
     */
    private boolean esSecuenciaCorrecta(List<String> resultado) {
        int countBlancas =0;
        for (String color: resultado){
            if (color.equals("Blanca")){
                countBlancas++;
            }
        }
        return countBlancas == 4;
    }

    /**
     * Método que lleva a cabo la lógica del juego, colaborando con los anteriores metodos encargados de la realización
     * de las funciones necesarias.
     */
    public void jugar() {
        System.out.println("Bienvenido a Mastermind!");
        System.out.println("Adivina la secuencia de colores de 4 elementos entre Azul, Rojo, Verde y Amarillo.");
        for (int intento = 1; intento <= ATTEMPTS; intento++) {
            System.out.println("Intento #" + intento);
            List<String> intentoJugador = obtenerIntentoJugador();
            List<String> resultado = procesarIntento(intentoJugador);
            mostrarResultado(resultado);
            if (esSecuenciaCorrecta(resultado)) {
                System.out.println("¡Felicidades! Has adivinado la secuencia en el intento #" + intento);
                return;
            }
        }
        System.out.println("Lo siento, has agotado tus intentos. La secuencia correcta era: " + sequence);
    }

    /**
     * Metodo principal que ejecuta el juego.
     * @param args
     */
    public static void main(String[] args) {
        Mastermind mastermind = new Mastermind();
        mastermind.jugar();
    }


}








=======
package com.cleanCode.CCJen.ejercicio6;

import java.util.*;

public class Mastermind {
    private static final List<String> AVAILABLE_COLOURS = Arrays.asList("AZUL","ROJO","VERDE","AMARILLO");
    private static final int ATTEMPTS =10;
    private List<String> sequence;

    /**
     * Constructor de la clase. Depende del @method generarSecuencia para crear la secuencia aleatoria de colores a adivinar.
     */
    public Mastermind() {
        this.sequence = generarSecuencia();
    }


    /**
     * Genera la secuencia aleatoria de 4 colores disponibles en la lista AVAILABLE_COLORS
     * @return  La secuencia aleatoria generada.
     */
    private List<String> generarSecuencia(){
        List<String> sequence= new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<4; i++){
            sequence.add(AVAILABLE_COLOURS.get(random.nextInt(AVAILABLE_COLOURS.size())));
        }
        return sequence;
    }


    /**
     * Permite obtener la respuesta del jugador, controlando que la respuesta se ajuste a los colores disponibles
     * @return La secuencia de colores dada por el jugador
     */
    private List<String> obtenerIntentoJugador() {

        Scanner scanner = new Scanner(System.in);
        List<String> intento = new ArrayList<>();
        for( int i=0; i<4;i++){
            System.out.print("Ingresa el color #"+(i+1)+": ");
            String color = scanner.nextLine().toUpperCase();
            while(!AVAILABLE_COLOURS.contains(color)){
                System.out.println("Color no valido. Ingresa uno de los siguientes colores (Azul,Rojo,Verde o Amarillo)");
                color = scanner.nextLine().toUpperCase();;
            }
                intento.add(color);
        }
        return intento;
    }

    /**
     * Verifica si el intento del jugador coincide con la secuencia final que se ha generado al inicio
     * @param intentoJugador La secuencia de colores dada por el jugador
     * @return El resultado del intento (Blanca=> color y posicion correcta,
     *                                   Negra => color correcto pero posición incorrecta,
     *                                   ? => el color no se encuentra en la lista generada.
     */
    private List<String> procesarIntento(List<String> intentoJugador) {
        List<String> resultado = new ArrayList<>();

        for (int i = 0; i < sequence.size(); i++) {
            String colorSecuencia = sequence.get(i);
            String colorIntento = intentoJugador.get(i);
            if (colorSecuencia.equals(colorIntento)) {
                resultado.add("Blanca");
            } else if (sequence.contains(colorIntento)) {
                resultado.add("Negra");
            } else {
                resultado.add("?");
            }
        }

        return resultado;
    }

    /**
     * Muestra el resultado del intento del jugador tras la verificacion
     * @param resultado El resultado generado por el metodo procesarItento
     */
    private void mostrarResultado(List<String> resultado) {
        System.out.println("Resultado: " + resultado);
    }

    /**
     * Método que comprueba que la respuesta del usuario es correcta = todos los elementos del resultado son "Blanca"
     * @param resultado El resultado generado por el metodo procesarItento
     * @return true si la secuencia es correcta
     *          false de lo contrario.
     */
    private boolean esSecuenciaCorrecta(List<String> resultado) {
        int countBlancas =0;
        for (String color: resultado){
            if (color.equals("Blanca")){
                countBlancas++;
            }
        }
        return countBlancas == 4;
    }

    /**
     * Método que lleva a cabo la lógica del juego, colaborando con los anteriores metodos encargados de la realización
     * de las funciones necesarias.
     */
    public void jugar() {
        System.out.println("Bienvenido a Mastermind!");
        System.out.println("Adivina la secuencia de colores de 4 elementos entre Azul, Rojo, Verde y Amarillo.");
        for (int intento = 1; intento <= ATTEMPTS; intento++) {
            System.out.println("Intento #" + intento);
            List<String> intentoJugador = obtenerIntentoJugador();
            List<String> resultado = procesarIntento(intentoJugador);
            mostrarResultado(resultado);
            if (esSecuenciaCorrecta(resultado)) {
                System.out.println("¡Felicidades! Has adivinado la secuencia en el intento #" + intento);
                return;
            }
        }
        System.out.println("Lo siento, has agotado tus intentos. La secuencia correcta era: " + sequence);
    }

    /**
     * Metodo principal que ejecuta el juego.
     * @param args
     */
    public static void main(String[] args) {
        Mastermind mastermind = new Mastermind();
        mastermind.jugar();
    }


}








>>>>>>> origin/main
