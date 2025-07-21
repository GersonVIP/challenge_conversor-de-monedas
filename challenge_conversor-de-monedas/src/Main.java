import java.util.Scanner;

public class Main {

    public static void mostrarMenu() {
        System.out.println("*************************************************\n");
        System.out.println("Sea bienvenid@ al Conversor de Monedas :)");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.print("Elija una opción: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDivisas conversor = new ConversorDivisas();
        int opcion;
        double cantidad;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f USD = %.2f ARS\n", cantidad, conversor.convertir("ARS", cantidad));
                    break;
                case 2:
                    System.out.print("Ingrese cantidad en ARS: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f ARS = %.2f USD\n", cantidad, conversor.convertirInversa("ARS", cantidad));
                    break;
                case 3:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f USD = %.2f BRL\n", cantidad, conversor.convertir("BRL", cantidad));
                    break;
                case 4:
                    System.out.print("Ingrese cantidad en BRL: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f BRL = %.2f USD\n", cantidad, conversor.convertirInversa("BRL", cantidad));
                    break;
                case 5:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f USD = %.2f COP\n", cantidad, conversor.convertir("COP", cantidad));
                    break;
                case 6:
                    System.out.print("Ingrese cantidad en COP: ");
                    cantidad = scanner.nextDouble();
                    System.out.printf("Resultado: %.2f COP = %.2f USD\n", cantidad, conversor.convertirInversa("COP", cantidad));
                    break;
                case 7:
                    System.out.println("Saliendo del sistema conversor.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 7);
        scanner.close();
    }
}
