
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan_9mx9tzb
 */
public class Persona {
    private int numeroPasajeros;
    
 public double generarPasajero() {
    int edad = (int) (Math.random() * 100 + 1); // Generar edad aleatoria entre 1 y 100 años
    double precio = 0;
   
    
    return precio;
}
    
    public int generarNumeroPasajeros() {
    Random rand = new Random();
    return rand.nextInt(5) + 1;
}
    
    
    
public int getNumeroPasajeros() {
    return numeroPasajeros;
}

public void setNumeroPasajeros(int numeroPasajeros) {
    this.numeroPasajeros = numeroPasajeros;
}

}
