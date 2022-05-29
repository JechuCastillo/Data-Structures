/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author marcelo.castillo
 */
public class Lista {

    private Nodo cabecera;
    private int longitud;
//Constructor

    public Lista() {
        cabecera = null;
        longitud = 0;
    }
//Insertar elemento

    public boolean insertar(Object unElemento, int pos) {
        boolean exito;
        int i;
        if (pos < 1 || pos > longitud + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(unElemento, this.cabecera);
            } else {
                i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevoNodo = new Nodo(unElemento, aux.getEnlace());
                aux.setEnlace(nuevoNodo);
            }
            exito = true;
            this.longitud++;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito;
        int i;
        if (pos < 1 || pos > longitud) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object unElemento;
        int i;
        if (pos < 1 || pos > this.longitud) {
            unElemento = null;
        } else {
            i = 1;
            Nodo aux = this.cabecera;
            while (i != pos) {
                //Recorre la lista con un nodo aux hasta la posicion dada.
                aux = aux.getEnlace();
                i++;
            }
            unElemento = aux.getElemento();
        }
        return unElemento;
    }

    public int localizar(Object unElemento) {
        int i = 1;
        int pos = -1;
        boolean encontrado = false;
        Nodo aux = this.cabecera;
        //Mientras no sea encontrado e i sea menor a longitud
        while (!encontrado && i <= this.longitud) {
            //Compara el elemento de la posicion i con el buscado 
            if (unElemento == aux.getElemento()) {
                pos = i;
                encontrado = true;
            } else {
                //Avanza el nodo Aux para buscar el elemento
                i++;
                aux = aux.getEnlace();
            }
        }
        return pos;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean esVacia() {
        return this.longitud == 0;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public Lista clone() {

        Lista clone = new Lista();
        if (this.cabecera != null) {
            clone.longitud = this.longitud;
            Nodo auxThis = this.cabecera;
            Nodo primerElemento = new Nodo(auxThis.getElemento(), null);
            clone.cabecera = primerElemento;
            Nodo auxClone = clone.cabecera;
            auxThis = auxThis.getEnlace();
            //Arranca de la posicion 2 porque ya clone el primer elemento
            for (int i = 2; i <= this.longitud; i++) {
                Nodo nuevo = new Nodo(auxThis.getElemento(), null);
                auxClone.setEnlace(nuevo);
                auxClone = nuevo;
                auxThis = auxThis.getEnlace();
            }
        }
        return clone;
    }

    public String toString() {
        String cadena = "";
        Nodo aux = this.cabecera;
        for (int i = 1; i <= this.longitud; i++) {
            cadena = cadena + aux.getElemento().toString() + " ";
            aux = aux.getEnlace();
        }
        return cadena;
    }

    public Lista invertir(Lista l1) {
        Nodo aux = l1.cabecera;
        Nodo anterior = new Nodo(null, null);
        Nodo siguiente = l1.cabecera.getEnlace();
        while (!(siguiente == null)) {
            aux.setEnlace(anterior);
            anterior = aux;
            aux = aux.getEnlace();
            siguiente = siguiente.getEnlace();
        }
        aux.setEnlace(anterior);
        l1.cabecera = aux;
        return l1;
    }

    /*public void eliminarApariciones(Object x) {
        Nodo siguiente, anterior;
        anterior = this.cabecera;
        siguiente = this.cabecera.getEnlace();
        while (!(siguiente == null)) {
            if (this.cabecera.getElemento().equals(x)) {
                anterior = anterior.getEnlace();
                siguiente = siguiente.getEnlace();
                this.cabecera = this.cabecera.getEnlace();
                this.longitud--;
            } else {
                if (siguiente.getElemento().equals(x)) {
                    anterior.setEnlace(anterior.getEnlace().getEnlace());
                    this.longitud--;
                }
                anterior = anterior.getEnlace();
                siguiente = siguiente.getEnlace();
            }
        }
        if (this.longitud == 1 && this.cabecera.getElemento().equals(x)) {
            this.longitud--;
            this.cabecera = null;
        }
    }*/
    public Lista obtenerMultiplos(int num) {
        Lista listaAux = new Lista();
        //Si no esta vacia, ejecuta.
        if (this.cabecera != null && num != 0) {
            Nodo auxOriginal = this.cabecera; //Apunto a la cabecera
            Nodo auxNuevo = null;// Nodo auxiliar para recorrer en la lista nueva.
            int i;
            int longitud = this.longitud;

            for (i = 1; i <= longitud; i++) {
                if (i % num == 0) {
                    //Arma la cabecera de la nueva lista.
                    if (listaAux.cabecera == null) {
                        listaAux.cabecera = new Nodo(auxOriginal.getElemento(), null);
                        auxNuevo = listaAux.cabecera;
                    } else {
                        // Arma nodos nuevos, los enlaza en la lista nueva y avanzamos en la lista.
                        Nodo nuevo = new Nodo(auxOriginal.getElemento(), null);
                        auxNuevo.setEnlace(nuevo);
                        auxNuevo = auxNuevo.getEnlace();
                    }
                    listaAux.longitud++;
                }
                auxOriginal = auxOriginal.getEnlace(); // recorre la lista original.
            }
        }
        return listaAux;
    }

    public void eliminarApariciones(Object x) {
        Nodo aux = this.cabecera;
        while (aux.getEnlace() != null) {
            //si la cabecera es igual a X, elimino la cabecera asignando una nueva.
            if (this.cabecera.getElemento().equals(x)) {
                this.cabecera = this.cabecera.getEnlace();
                this.longitud--;
            } else {
                //Verifico que el siguiente elemento sea igual x para eliminarlo
                if (aux.getEnlace().getElemento().equals(x)) {
                    aux.setEnlace(aux.getEnlace().getEnlace());
                    this.longitud--;
                } else {
                    //No avanza hasta estar seguro que el siguiente sea distinto de X
                    aux = aux.getEnlace();
                }
            }
        }

    }
}
