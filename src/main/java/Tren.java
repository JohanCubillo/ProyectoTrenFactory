
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Tren implements Observable {
    private ArrayList<Observer> observers;
    
    VagonFactory vagon = new VagonFactory();
    
    private Vagon[] vagones;
    private double precioAdulto = 700; // Precio del tiquete para adultos
    private double precioNino = 450; // Precio del tiquete para niños
    private double precioJoven = 550; // Precio del tiquete para jóvenes
    private double precioAdultoMayor = 0; // Precio del tiquete para adultos mayores
    private double totalRecaudadoDia = 0.0; // Total recaudado en el día
    private double[] recaudacionEstacion = new double[8]; // Recaudación en cada estación
    private int capacidadMaxima;
    private int pasajeros;
    private int[] espacioDisponiblePorVagon = new int[4]; // Espacio disponible en cada vagón
    private int[] espacioDisponibleAnteriorPorVagon = new int[4]; // Espacio disponible en cada vagón en la parada anterior
    private double[] recaudacionPorDia = new double[8]; // Recaudación diaria en cada día
    private String[] arreglo1 = {"Estación Atlántico", "UCR", "Ulatina", "CFIA", "UACA", "Tres Ríos", "Estación de Cartago", "Los Ángeles"};
    private String[] arreglo2 = {"Los Ángeles", "Estación de Cartago", "Tres Ríos", "UACA", "CFIA", "Ulatina", "UCR", "Estación Atlántico"};
    private String[] horas = {"06:30 am", "07:30 am", "08:30 am",  "09:30 am", "10:30 am", "11:30 am", "13:30 am", "1:30 pm"};

    public Tren() {
        observers = new ArrayList<>();
        vagones = new Vagon[4];
        this.capacidadMaxima = 90;
        for (int i = 0; i < 4; i++) {
            this.vagones[i] = this.vagon.crearVagon();
            espacioDisponiblePorVagon[i] = capacidadMaxima;
            espacioDisponibleAnteriorPorVagon[i] = capacidadMaxima;
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

public void notifyObservers(double totalRecaudadoDia, double[] recaudacionEstacion) {
    for (Observer observer : observers) {
        observer.update(totalRecaudadoDia, recaudacionEstacion);
    }
}

        

public void simularParada(int parada,String diasemana, String ruta) {
    // ...
   
    
  
    
    if (diasemana.equalsIgnoreCase("domingo")) {
        System.out.println("Lo siento, no hay servicio los domingos.");
        
    }
    
     boolean primeraVez = true; // Variable para controlar la pregunta inicial
    int opcion = 0;
    
   
    // Agregar mensaje para pedir al usuario que elija una opción
   
    double totalRecaudado = 0.0;
    double recaudacionAdultos = 0.0;
    double recaudacionNinos = 0.0;
    double recaudacionJovenes = 0.0;
    double recaudacionAdultosMayores = 0.0;
    
    
    int totalAdultos = 0;
    int totalNinos = 0;
    int totalJovenes = 0;
    int totalAdultosMayores = 0;
    
    
    int totalAdultosSuben = 0;
    int totalNinosSuben = 0;
    int totalJovenesSuben = 0;
    int totalAdultosMayoresSuben = 0;
    
    int totalAdultosBajan = 0;
    int totalNinosBajan = 0;
    int totalJovenesBajan = 0;
    int totalAdultosMayoresBajan = 0;
    
    
    
    int totalNinosAnterior = 0;
    
    double[][] totalesPorVagon = new double[4][8];
    double[][] totalesPorParada = new double[8][4];
    int espacioDisponibleAnterior = capacidadMaxima;
    double[] recaudacionPorParada = new double[8];
    double[] totalesPorDia = new double[8];
    double[] totalesPorNino = new double[8];
    double[] totalesPorJoven = new double[8];
    double[] totalesPorAdulto = new double[8];
    
    
    double [] totalesPorNinoporparada=new double[8];
    double [] totalesPorJovenporparada=new double[8];
    double [] totalesPorAdultoporparada=new double[8];
    double [] totalesPorAdultomayorporparada=new double[8];
    
    
 for (int i = 0; i < 4; i++) {
    System.out.print("Vagón " + (i + 1) + ": ");
    if (ruta.equalsIgnoreCase("SanJose-Cartago")) {
        System.out.println("Parada " + parada + ": " + arreglo1[parada-1]);
    }
    if (ruta.equalsIgnoreCase("Cartago-SanJose")) {
        System.out.println("Parada " + parada + ": " + arreglo2[parada-1]);
        precioAdulto = 600;
        precioJoven = 450;
        precioNino = 400;
    }
    System.out.println("Hora " + horas[parada-1]);

      Persona p = new Persona();
       double recaudado = vagones[i].subirPasajeros(p.generarPasajero(),p.generarPasajero(),p.generarPasajero(),p.generarPasajero());
       totalesPorVagon[i][parada - 1] += recaudado;
        int[] contadoresSuben = vagones[i].getContadoresSuben();
        int[] contadoresBajan = vagones[i].getContadoresBajan();
        espacioDisponibleAnteriorPorVagon[i] = espacioDisponiblePorVagon[i];
        int pasajerosQueBajan = contadoresBajan[0] + contadoresBajan[1] + contadoresBajan[2] + contadoresBajan[3];
        if (pasajerosQueBajan > capacidadMaxima) {
            espacioDisponiblePorVagon[i] = 0;
        } else {
            espacioDisponiblePorVagon[i] = capacidadMaxima - contadoresSuben[0] - contadoresSuben[1] - contadoresSuben[2] - contadoresSuben[3] + pasajerosQueBajan;
        }
        if (parada != 1) {
            vagones[i].bajarPasajeros();
        }

        totalAdultosSuben += contadoresSuben[0];
        totalNinosSuben += contadoresSuben[1];
        totalAdultosBajan += contadoresBajan[0];
        totalNinosBajan += contadoresBajan[1];
        totalRecaudado += recaudado;
        recaudacionAdultos += contadoresSuben[0] * precioAdulto;
        recaudacionNinos += contadoresSuben[1] * precioNino;
        recaudacionJovenes += contadoresSuben[2] * precioJoven;
        recaudacionAdultosMayores += contadoresSuben[3] * precioAdultoMayor;
        
        
        totalAdultos += contadoresSuben[0] - contadoresBajan[0];
        totalNinos += contadoresSuben[1] - contadoresBajan[1];
        totalJovenes += contadoresSuben[2] - contadoresBajan[2];
        totalAdultosMayores += contadoresSuben[3] - contadoresBajan[3];
        
        recaudacionPorDia[parada - 1] = totalRecaudado;
        
        
        if (totalNinosAnterior < contadoresBajan[1]) {
            totalNinosBajan += contadoresBajan[1] - totalNinosAnterior;
        }
        totalNinosAnterior = contadoresSuben[1];
       int contsuben = contadoresSuben[0] - contadoresBajan[0];
       int contbajan= contadoresSuben[1] - contadoresBajan[1];
if (contsuben < 0) {
        contsuben = 0;
    }
    if (contbajan < 0) {
        contbajan = 0;
    }
    
    totalRecaudadoDia += totalRecaudado;
    
        System.out.println("Suben ---" + contadoresSuben[0] + " adultos  --- " + contadoresSuben[1] + " niños --- "+ contadoresSuben[2] + " jovenes ---"+ contadoresSuben[3] + " adultos mayores al vagón.");
        System.out.println("Bajan " + contadoresBajan[0] + " adultos y " + contadoresBajan[1] + " niños del vagón."+ contadoresBajan[1] + " jovenes del vagón."+ contadoresBajan[1] + " adultos mayores del vagón.");
        
       
        
        System.out.println("Espacio disponible: " + espacioDisponiblePorVagon[i] + " pasajeros.");
        System.out.println("Total de adultos en el vagón: "+ contsuben);
        System.out.println("Total de niños en el vagón: " + contbajan);
        System.out.println("---------------------------------------------");
           
int resultado = (int) (contadoresSuben[0] * precioAdulto);
int resultado2 = (int) (contadoresSuben[1] * precioNino);
int resultado3 = (int) (contadoresSuben[2] * precioJoven);


int total= resultado+resultado2+resultado3;

totalesPorDia[parada - 1] += total;
totalesPorNino[parada - 1] += resultado2;
totalesPorJoven[parada - 1] += resultado3;
totalesPorAdulto[parada - 1] += resultado;




totalesPorNinoporparada[parada - 1] += contadoresSuben[1];
totalesPorJovenporparada[parada - 1] += contadoresSuben[2];
totalesPorAdultoporparada[parada - 1] += contadoresSuben[0];
totalesPorAdultomayorporparada[parada - 1] += contadoresSuben[3];




System.out.println("El monto hasta ahora es de "+(totalesPorDia[parada - 1]));

System.out.println("Recaudación por adultos: " + (contadoresSuben[0] * precioAdulto));
System.out.println("Recaudación por niños: " + (contadoresSuben[1] * precioNino));
System.out.println("Recaudación por jovenes: " + (contadoresSuben[2] * precioJoven));
System.out.println("Recaudación por adultos mayores: " + (contadoresSuben[3] * precioAdultoMayor));
System.out.println("Recaudado en la estacion: " + total);


 System.out.println("---------------------------------------------");

     
 System.out.println("---------------------------------------------");
 System.out.println("---------------------------------------------");
    }

System.out.println("Monto total por Niños :" + totalesPorNino[parada - 1]);

System.out.println("Monto total por Jovenes :" + totalesPorJoven[parada - 1]);

System.out.println("Monto total por Jovenes :" + totalesPorAdulto[parada - 1]);

System.out.println("Monto total por Adulto Mayor : 0 " );
System.out.println("El monto total al final del dia es de  "+(totalesPorDia[parada - 1]));
    System.out.println("El total es de niños:" +totalesPorNinoporparada[parada - 1] +"--- Jovenes "+totalesPorJovenporparada[parada - 1]+"--- adultos" +totalesPorAdultoporparada[parada - 1]+"---Adultos mayores" +totalesPorAdultomayorporparada[parada - 1]);
}


  
        
       
       
    }



       
    





    