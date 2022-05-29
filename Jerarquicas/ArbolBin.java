/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

import lineales.dinamicas.*;

/**
 *
 * @author Admin
 */
public class ArbolBin {

    //Atributo
    private NodoArbol raiz;

    //Constructor
    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevo, Object padre, char lugar) {
        boolean exito = true;
        //Si el arbol esta vacio se crea la raiz.
        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevo, null, null);
        } else {
            //Si arbol no esta vacio busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, padre);

            //si nPadre existe y el lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'i' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(nuevo, null, null));
                } else if (lugar == 'd' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(nuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //Metodo PRIVADO para buscar un elemento y devuelve el nodo que lo contiene
        //o null si no lo encuentra.
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElemento().equals(buscado)) {
                //si el buscado es igual a n, lo devuelve
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encuentra en el hijo izq, busca en hijo der.
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Object padre(Object x) {
        Object res = null;
        if (this.raiz != null) {
            res = buscarPadre(this.raiz, x);
        }
        return res;
    }

    private Object buscarPadre(NodoArbol nPadre, Object hijo) {
        Object resultado = null;
        if (this.raiz.getElemento().equals(hijo)) {
            resultado = "No tiene padre.";
        } else {
            if (nPadre != null) {
                if (nPadre.getIzquierdo() != null && nPadre.getIzquierdo().getElemento().equals(hijo)) {
                    resultado = nPadre.getElemento();
                } else if (nPadre.getDerecho() != null && nPadre.getDerecho().getElemento().equals(hijo)) {
                    resultado = nPadre.getElemento();
                } else {
                    resultado = buscarPadre(nPadre.getIzquierdo(), hijo);
                    if (resultado == null) {
                        resultado = buscarPadre(nPadre.getDerecho(), hijo);
                    }
                }
            }
        }
        return resultado;
    }

    public Lista listarPreorden() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            preOrden(this.raiz, l1);
        }
        return l1;
    }

    private void preOrden(NodoArbol nodo, Lista l1) {
        if (nodo != null) {
            l1.insertar(nodo.getElemento(), l1.longitud() + 1);
            preOrden(nodo.getIzquierdo(), l1);
            preOrden(nodo.getDerecho(), l1);
        }
    }

    public Lista listarInorden() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            inOrden(this.raiz, l1);
        }
        return l1;
    }

    private void inOrden(NodoArbol nodo, Lista l1) {
        if (nodo != null) {
            inOrden(nodo.getIzquierdo(), l1);
            l1.insertar(nodo.getElemento(), l1.longitud() + 1);
            inOrden(nodo.getDerecho(), l1);
        }
    }

    public Lista listarPosorden() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            posOrden(this.raiz, l1);
        }
        return l1;
    }

    private void posOrden(NodoArbol nodo, Lista l1) {
        if (nodo != null) {
            posOrden(nodo.getIzquierdo(), l1);
            posOrden(nodo.getDerecho(), l1);
            l1.insertar(nodo.getElemento(), l1.longitud() + 1);
        }
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            generarClon(clon);
        }
        return clon;
    }

    private void generarClon(ArbolBin clon) {
        clon.raiz = new NodoArbol(this.raiz.getElemento(), null, null);
        clonar(clon.raiz, this.raiz);
    }

    private void clonar(NodoArbol clon, NodoArbol original) {
        if (original != null && clon != null) {
            if (original.getIzquierdo() != null) {
                NodoArbol nuevo = new NodoArbol(original.getIzquierdo().getElemento(), null, null);
                clon.setIzquierdo(nuevo);
            }
            if (original.getDerecho() != null) {
                NodoArbol nuevo = new NodoArbol(original.getDerecho().getElemento(), null, null);
                clon.setDerecho(nuevo);
            }
            clonar(clon.getIzquierdo(), original.getIzquierdo());
            clonar(clon.getDerecho(), original.getDerecho());
        }
    }

    public String toString() {
        String cadena = "";
        if (this.raiz != null) {
            cadena = mostrarArbol(cadena, this.raiz);
        }
        return cadena;
    }

    private String mostrarArbol(String cadena, NodoArbol nodo) {
        if (nodo != null) {
            cadena = cadena + "P:" + nodo.getElemento() + " ";
            if (nodo.getIzquierdo() == null) {
                cadena = cadena + "HI:-" + " ";
            } else {
                cadena = cadena + "HI:" + nodo.getIzquierdo().getElemento();
            }
            if (nodo.getDerecho() == null) {
                cadena = cadena + "HD: -\n";
            } else {
                cadena = cadena + "HD: " + nodo.getDerecho().getElemento() + "\n";
            }
            cadena = mostrarArbol(cadena, nodo.getIzquierdo());
            cadena = mostrarArbol(cadena, nodo.getDerecho());
        }
        return cadena;
    }

    public Lista listarPorNiveles() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            porNivel(l1);
        }
        return l1;
    }

    private void porNivel(Lista l1) {
        Cola colaAux = new Cola();
        colaAux.poner(this.raiz);
        while (!(colaAux.esVacia())) {
            NodoArbol actual = (NodoArbol) colaAux.obtenerFrente();
            colaAux.sacar();
            l1.insertar(actual.getElemento(), l1.longitud() + 1);
            if (actual.getIzquierdo() != null) {
                colaAux.poner(actual.getIzquierdo());
            }
            if (actual.getDerecho() != null) {
                colaAux.poner(actual.getDerecho());
            }
        }
    }

    public int altura() {
        int altura = -1;
        if (this.raiz != null) {
            altura = contarAltura(0, this.raiz);
        }
        return altura;
    }

    private int contarAltura(int max, NodoArbol nodo) {
        int izq, der;
        if (nodo != null) {
            izq = contarAltura(max + 1, nodo.getIzquierdo());
            der = contarAltura(max + 1, nodo.getDerecho());
            if (izq > der) {
                max = izq;
            } else {
                max = der;
            }
        }
        return max;
    }

    public int nivel(Object elemento) {
        int nivel = -1;
        if (this.raiz != null) {
            nivel = hallarNivel(elemento, this.raiz, nivel + 1);
        }
        return nivel;
    }

    private int hallarNivel(Object elemento, NodoArbol nodo, int nivel) {
        boolean encontrado = false;
        if (nodo != null) {
            if(elemento.equals(nodo.getElemento())){
                encontrado=true;
            }
        }
        return nivel;
    }

}
