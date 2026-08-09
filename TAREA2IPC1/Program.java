import java.util.Scanner;
public class Program {

    // Método 1: main 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // M1: Declaración de variables: 4 tipos primitivos 
        int cantidadJugadores = 5;
        double pingPromedio = 0.0; 
        boolean servidorActivo = true;
        char rangoDefault = 'U'; 

        // ENCABEZADO
        System.out.println("==== SISTEMA DE ESTADISTICAS MCGUAT ====");
        System.out.println("Estado del Servidor: " + (servidorActivo ? "ONLINE" : "OFFLINE"));
        System.out.println("Rango de nuevos jugadores: [" + rangoDefault + "]");
        
        // Llamada a los métodos modulares
        procesarPingsUnidimensional(scanner, cantidadJugadores);
        procesarRecursosBidimensional(scanner);
        
        System.out.println("\n==== SISTEMA CERRADO ====");
        scanner.close();
    }

    // M2: Validación de entrada: Rechazo de letras y números fuera de rango basicamente lo que hace que el programa no muera xd
    public static int solicitarEnteroValido(Scanner scanner, String mensaje, int min, int max) {
        int numero = 0;
        boolean datoValido = false;

        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) { // verificacion de entero
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) { // verificacion de rango de numero, por si el usuario ingresa un numero fuera del rango o texto que no va entender mi codigo
                    datoValido = true; 
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max + "."); // mensaje de error
                }
            } else {
                System.out.println("Error: Ingreso inválido. Debes ingresar un número entero."); // mensaje de error
                scanner.next(); // limpiar para que no entre en bucle infinito
            }
        } while (!datoValido); // repetir hasta que el dato sea valido

        return numero;
    }

    // M3: Arreglo Unidimensional: Cálculo de min, max y promedio
    public static void procesarPingsUnidimensional(Scanner scanner, int cantidad) {
        System.out.println("\n--- MÓDULO DE CONEXIONES (Arreglo 1D) ---");
        int[] pings = new int[cantidad]; // array para almacenar los pings de los jugadores
        int sumaPings = 0; // acumulador para calcular el promedio

        // Llenado del arreglo con validación
        for (int i = 0; i < pings.length; i++) {
            pings[i] = solicitarEnteroValido(scanner, "Ingresa el ping del jugador " + (i + 1) + " (0 - 1000 ms): ", 0, 1000); // validación de ping entre 0 y 1000 ms
            sumaPings += pings[i];
        }

        // Cálculo de máximo y mínimo
        int min = pings[0];
        int max = pings[0];
        for (int i = 1; i < pings.length; i++) { // empezamos desde 1 porque ya inicializamos min y max con el primer elemento
            if (pings[i] < min) min = pings[i]; // actualización del mínimo
            if (pings[i] > max) max = pings[i]; // actualización del máximo
        }

        double promedio = (double) sumaPings / pings.length; // cálculo del promedio

        System.out.println("\n>>> RESUMEN DE CONEXIÓN <<<");
        System.out.println("Ping Máximo registrado: " + max + " ms");
        System.out.println("Ping Mínimo registrado: " + min + " ms");
        System.out.println("Ping Promedio global: " + promedio + " ms");
    }

    // M4 Array Bidimensional: Recursos, formato de tabla y sumatorias Area visual
    public static void procesarRecursosBidimensional(Scanner scanner) { // método para procesar recursos minados por jugadores
        System.out.println("\n--- MÓDULO DE RECURSOS MINADOS (Arreglo 2D) ---");
        int filas = 3; // 3 jugadores de muestra
        int columnas = 2; // 2 recursos: Diamantes y Hierro
        int[][] recursos = new int[filas][columnas]; // matriz para almacenar los recursos minados por cada jugador

        // Llenado de la matriz con validación
        for (int i = 0; i < filas; i++) {
            System.out.println("Datos del Jugador " + (i + 1) + ":");
            recursos[i][0] = solicitarEnteroValido(scanner, "  Diamantes minados (0 - 64): ", 0, 64); // validación de diamantes entre 0 y 64
            recursos[i][1] = solicitarEnteroValido(scanner, "  Hierro minado (0 - 64): ", 0, 64); // validación de hierro entre 0 y 64
        }

        System.out.println("\n>>> INVENTARIO DEL SERVIDOR <<<");
        System.out.println("Jugador\t| Diamantes\t| Hierro");
        System.out.println("---------------------------------");
        
        int totalDiamantes = 0; // acumulador para diamantes
        int totalHierro = 0; // acumulador para hierro
        for (int i = 0; i < filas; i++) {
            totalDiamantes += recursos[i][0]; 
            totalHierro += recursos[i][1]; // acumulación de recursos
        }
    