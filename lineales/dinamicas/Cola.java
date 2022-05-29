/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Admin
 */
public class Cola {

    //Atributos
    private Nodo frente;
    private Nodo fin;

    //Constructor
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    //
    public boolean poner(Object unElemento) {
        Nodo nuevo = new Nodo(unElemento, null);
        if (this.frente == null) {
            this.frente = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
        return true;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.frente == null) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object unElemento;
        if (this.frente == null) {
            unElemento = null;
        } else {
            unElemento = this.frente.getElemento();
        }
        return unElemento;
    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public void vaciar() {
       this.frente=null;
       this.fin=null;
    }

    public Cola clone() {
        Cola clon = new Cola();
        Nodo aux;
        aux = this.frente;
        Nodo nuevo1 = new Nodo(aux.getElemento(), null);
        clon.frente = nuevo1;
        clon.fin = nuevo1;
        aux = aux.getEnlace();
        while (aux != null) {
            Nodo nuevo2 = new Nodo(aux.getElemento(), null);
            clon.fin.setEnlace(nuevo2);
            clon.fin = nuevo2;
            aux = aux.getEnlace();
        }

        return clon;
    }

    public String toString() {
        String cadena = "[";
        Nodo aux;
        aux = this.frente;
        while (aux != null) {
            cadena += aux.getElemento() + " ";
            aux = aux.getEnlace();
        }
        cadena += "]";
        return cadena;
    }
}
