import java.util.Random;


 class Vagon {
    private int[] contadoresSuben = new int[4];
    private int[] contadoresBajan = new int[4];
    
    private double precioAdulto;
    private double precioNino;
    
    private double recaudado;
    
    private int asientosDisponibles; // Nueva variable
     private int contadorPersonas; // Contador de personas en el vagón
     
     private int adultosBajan;
    private int ninosBajan;
    private int adultosmayoresBajan;
    private int jovenesBajan;
    
    private double[][] totalesPorVagon = new double[4][8];
    
    public Vagon() {
        
        this.recaudado = 0;
        this.asientosDisponibles = 90; // Inicializar variable
        contadorPersonas = 0;
        ninosBajan=0;
        adultosBajan=0;
    } 
 
 
 public static Vagon crearVagon() {
        return new Vagon();
    }
 
    
   public double subirPasajeros(double precioAdulto, double precioNino, double precioAdultoMayor, double precioJoven) {
       Persona p = new Persona();
    int adultos = p.generarNumeroPasajeros();
    int ninos = p.generarNumeroPasajeros();
    int adultosMayores = p.generarNumeroPasajeros();
    int jovenes = p.generarNumeroPasajeros();
    this.contadoresSuben[0] += adultos;
    this.contadoresSuben[1] += ninos;
    this.contadoresSuben[2] += jovenes;
    this.contadoresSuben[3] += adultosMayores;
    contadorPersonas += (adultos + ninos + adultosMayores + jovenes);
    this.asientosDisponibles -= (adultos + ninos + adultosMayores + jovenes); // Actualizar variable
    double recaudado = adultos * precioAdulto + ninos * precioNino + adultosMayores * precioAdultoMayor + jovenes * precioJoven;
    this.recaudado += recaudado;
    return recaudado;
}
    
    
    public void bajarPasajeros() {
        Persona p = new Persona();
        int adultos = p.generarNumeroPasajeros();
        int ninos = p.generarNumeroPasajeros();
        int jovenes = p.generarNumeroPasajeros();
        int adultosmayores = p.generarNumeroPasajeros();
        this.contadoresBajan[0] += adultos;
        this.contadoresBajan[1] += ninos;
        this.contadoresBajan[2] += jovenes;
        this.contadoresBajan[3] += adultosmayores;
        contadorPersonas -= (adultosBajan + ninosBajan + adultosmayoresBajan + jovenesBajan);
        this.asientosDisponibles += (adultos + ninos + jovenes + adultosmayores); // Actualizar variable
    }
    
    public int[] getContadoresSuben() {
        return contadoresSuben;
    }
    
    public int[] getContadoresBajan() {
        return contadoresBajan;
    }
    
    public double getRecaudado() {
        return recaudado;
    }
    
    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }
    

}