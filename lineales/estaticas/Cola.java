/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Admin
 */
public class Cola {

    private static final int tamanio = 10;
    private Object array[];
    private int frente;
    private int fin;

    public Cola() {
        this.array = new Object[tamanio];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object unElemento) {
        boolean exito = false;
        if (!colaLlena()) {
            this.array[fin] = unElemento;
            this.fin = (this.fin + 1) % tamanio;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = false;
        if (!esVacia()) { //Precondicion, verifica que no este vacia
            this.array[frente] = null;
            this.frente = (this.frente + 1) % tamanio;
            exito = true;
        }
        return exito;
    }

    private boolean colaLlena() {
        return (this.fin + 1) % tamanio == this.frente; 
    }

    public boolean esVacia() {
        return this.frente == this.fin;
    }

    public Object obtenerFrente() {
        Object unElemento;
        if (esVacia()) { 
            // si esta vacia devuelve null
            unElemento = null;
        } else {
            unElemento = this.array[frente];
        }
        return unElemento;
    }

    public void vaciar() {
        while (this.frente != this.fin) {
            this.array[frente] = null;
            this.frente = (frente + 1) % tamanio;
        }
    }

    public Cola clone() {
        Cola clon = new Cola();
        if (!esVacia()) { //verifica que no este vacia la cola para clonar;
            clon.array = this.array.clone();
        }
            clon.fin = this.fin; //como puede quedar vacia en cualquier posicion se asigna despues.
            clon.frente = this.frente;
        return clon;
    }

    public String toString() {
        String cadena = "[";
        int elFrente, elFin;
        elFrente = this.frente;
        elFin = this.fin;
        while (elFrente < elFin) {
            cadena = cadena + this.array[elFrente] + " ";
            elFrente = (elFrente + 1) % tamanio;
        }
        cadena=cadena+"]";
        return cadena;
    }
}
