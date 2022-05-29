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
public class NodoGen {

    private Object elemento;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    public NodoGen(Object elemento, NodoGen izquierdo, NodoGen hermanoDer) {
        this.elemento = elemento;
        this.hijoIzquierdo = izquierdo;
        this.hermanoDerecho = hermanoDer;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setHijoIzquierdo(NodoGen izquierdo) {
        this.hijoIzquierdo = izquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

}
