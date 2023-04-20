

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author johan_9mx9tzb
 */
public interface Observable {
   
    void agregarObservador(Observer observador);
    void removerObservador(Observer observador);
    void notificarObservadores();
}

