/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @Jesus Castillo FAI-2602
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int tamanio = 10;

    public Pila() {
        this.arreglo = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElemento) {
        boolean exito;
        if (this.tope + 1 >= this.tamanio) {
            // ERRAWR: Pila llena.
            exito = false;
        } else {
            // pone el elemento en el tope de la pila e incrementa el tope
            this.tope++;
            this.arreglo[tope] = nuevoElemento;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;
        if (this.esVacia()) {
            exito = false; // Si esta vacía no puede desapilar.
        } else {
            this.arreglo[tope] = null;// null al elemento del tope para vaciarlo
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object unElemento;
        if (this.esVacia()) { //Si esta vacía devuelve null, porque no hay elementos.
            unElemento = null;
        } else {
            unElemento = this.arreglo[tope]; // Devuelve el elemento que esta en el tope.
        }
        return unElemento;
    }

    public boolean esVacia() {
        boolean estaVacia = true;
        if (this.tope != -1) { //Si tope es distinto de -1 es porque la pila tiene al menos 1 elemento
            estaVacia = false;
        }
        return estaVacia;
    }

    public void vaciar() {
        int i;
        i = this.tope;
        while (i >= 0) {
            this.arreglo[i] = null;
            i--;
        }
        tope = -1;
    }

    public Pila clone() {
        Pila clon = new Pila();
        int i = 0;
        clon.tope = this.tope;
        if (!(this.esVacia())) {
            //Copia los elementos del objeto en el clon.
            clon.arreglo = this.arreglo.clone();
        }
        return clon;
    }

    public String toString() {
        String cadena = "[";
        int i = 0;
        if (this.esVacia()) {
            System.out.println("La pila esta vacía");
        } else {
            while (i <= this.tope) {
                // Concatena los elementos de la pila en un String.
                cadena = cadena+this.arreglo[i] + "-";
                i++;
            }
            cadena = cadena + "]";
        }
        return cadena;
    }

}
