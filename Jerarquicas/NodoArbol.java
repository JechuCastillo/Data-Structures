/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

/**
 *
 * @author Admin
 */
public class NodoArbol {
//Atributo

    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

//Constructor
    public NodoArbol(Object elemento, NodoArbol izq, NodoArbol der) {
        this.elemento = elemento;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    public void setElemento(Object elemento) {
        this.elemento=elemento;
    }
    
    public void setIzquierdo(NodoArbol izq){
        this.izquierdo=izq;
    }
    public void setDerecho(NodoArbol der){
        this.derecho=der;
    }

}
