import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Convertidordivisas conversor = new Convertidordivisas("df7c215591cd5ca610cf0845");

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    conversor.Convertidordivisas("USD", "MXN");
                    break;
                case 2:
                    conversor.Convertidordivisas("MXN", "USD");
                    break;
                case 3:
                    conversor.Convertidordivisas("USD", "AUD");
                    break;
                case 4:
                    conversor.Convertidordivisas("AUD", "USD");
                    break;
                case 5:
                    conversor.Convertidordivisas("USD", "CAD");
                    break;
                case 6:
                    conversor.Convertidordivisas("CAD", "USD");
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Corrige la opción. Elige del 1 al 7.");
            }
        }
        System.out.println("Proceso terminado. ¡Hasta pronto!");
    }

    private static void mostrarMenu() {
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("1. Convertir USD a MXN");
        System.out.println("2. Convertir MXN a USD");
        System.out.println("3. Convertir USD a AUD");
        System.out.println("4. Convertir AUD a USD");
        System.out.println("5. Convertir USD a CAD");
        System.out.println("6. Convertir CAD a USD");
        System.out.println("7. Salir");
        System.out.print("Escoge la opción deseada: ");
    }
}
