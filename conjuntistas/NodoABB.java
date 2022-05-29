/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Admin
 */
public class NodoABB {

    private Comparable elemento;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(Comparable elemento, NodoABB izq, NodoABB der) {
        this.elemento = elemento;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public Comparable getElemento() {
        return this.elemento;
    }

    public NodoABB getIzquierdo() {
        return this.izquierdo;
    }

    public NodoABB getDerecho() {
        return this.derecho;
    }

    public void setElemento(Comparable elem) {
        this.elemento = elem;
    }

    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }

    public void setDerecho(NodoABB der) {
        this.derecho = der;
    }
}
