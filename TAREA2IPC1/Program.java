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

    // M2: Validación de entrada: Rechazo de letras y números fuera de rango
    public static int solicitarEnteroValido(Scanner scanner, String mensaje, int min, int max) {
        int numero = 0;
        boolean datoValido = false;

        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) { // verificacion de entero
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) {
                    datoValido = true; 
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max + "."); // mensaje de error
                }
            } else {
                System.out.println("Error: Ingreso inválido. Debes ingresar un número entero."); // mensaje de error
                scanner.next(); // 
            }
        } while (!datoValido); // repetir hasta que el dato sea valido

        return numero;
    }
