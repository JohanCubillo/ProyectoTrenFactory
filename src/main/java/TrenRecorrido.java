
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan_9mx9tzb
 */
public class TrenRecorrido extends Tren{

     public static void main(String[] args) {
         
        TrenRecorrido tren = new TrenRecorrido();
    
        Random random = new Random();
        
                Scanner scanner = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Ingresa una ruta: ");
                String texto = scanner2.nextLine();
                
        String diaSemana;
        boolean esDiaValido = false;
        
        // Solicitar al usuario que ingrese un día de la semana
        System.out.print("Ingrese un día de la semana: ");
        diaSemana = scanner.nextLine();
        
        // Validar si el día ingresado es válido
        switch (diaSemana.toLowerCase()) {
            case "lunes":
            case "martes":
            case "miércoles":
            case "jueves":
            case "viernes":
            case "sábado":
                case "Lunes":
            case "Martes":
            case "Miércoles":
                case "Miercoles":
            case "Jueves":
            case "Viernes":
            case "Sábado":
                
                esDiaValido = true;
                break;
            case "domingo":
                case "Domingo":
                System.out.println("Lo siento, no hay servicio los domingos.");
                break;
            default:
                System.out.println("El día ingresado no es válido.");
                break;
        }
        
        if (esDiaValido) {
            System.out.println("Ha seleccionado el día " + diaSemana + ".");
             for (int i = 1; i <= 8; i++) {
            tren.simularParada(i,diaSemana,texto);
            try {
                Thread.sleep(1000); // Esperar un segundo antes de la siguiente parada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        
        scanner.close();
}

 @Override
    public void agregarObservador(Observer observador) {
        // Implementación de agregarObservador
    }

    @Override
    public void removerObservador(Observer observador) {
        // Implementación de removerObservador
    }

    @Override
    public void notificarObservadores() {
        System.out.println("Se realizo el viaje del tren");
    }

    public void update(double totalRecaudadoDia, double[] recaudacionEstacion) {
        // Implementación de update
    }
}
