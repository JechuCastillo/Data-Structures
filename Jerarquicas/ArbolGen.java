/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author Mellado Agustin FAI-1941, Castillo Jesus FAI-2602
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemento, Object padre) {
        boolean exito = false;
        if (this.raiz == null) { // si esta vacio inserta como raiz
            this.raiz = new NodoGen(elemento, null, null);
            exito = true;
        } else {
            NodoGen nPadre = obtenerNodo(padre, this.raiz); // busca el padre del elemento a insertar
            if (nPadre != null) { //Si lo encuentra lo inserta
                insertaAux(nPadre, elemento);
                exito = true;
            }
        }
        return exito;
    }

    private void insertaAux(NodoGen nodoPadre, Object elemento) {
        //Con el padre encontrado recorremos sus hijos para insertarlo.
        if (nodoPadre.getHijoIzquierdo() == null) { //Si no tiene HEI lo inserta como tal.
            nodoPadre.setHijoIzquierdo(new NodoGen(elemento, null, null));
        } else {
            //Si ya posee HEI se para en este y luego recorre sus hermanos
            //derechos hasta que el siguiente sea null.
            nodoPadre = nodoPadre.getHijoIzquierdo();
            while (nodoPadre.getHermanoDerecho() != null) {
                nodoPadre = nodoPadre.getHermanoDerecho();
            }
            nodoPadre.setHermanoDerecho(new NodoGen(elemento, null, null));
        }
    }

    private NodoGen obtenerNodo(Object padre, NodoGen nodo) {
        NodoGen encontrado = null;
        if (nodo != null) {
            if (nodo.getElemento().equals(padre)) { //Si el elemento del nodo es igual al padre, lo encontro.
                encontrado = nodo;
            } else {
                //busca en pre-orden
                encontrado = obtenerNodo(padre, nodo.getHijoIzquierdo());
                if (encontrado == null) {
                    if (nodo.getHijoIzquierdo() != null) {
                        NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                        while (hijo != null && encontrado == null) {
                            encontrado = obtenerNodo(padre, hijo);
                            hijo = hijo.getHermanoDerecho();
                        }
                    }
                }
            }

        }
        return encontrado;
    }

    public boolean pertenece(Object elemento) {
        boolean pertenece = false;
        if (this.raiz != null) {
            //Reutiliza el metodo obtenerNodo privado para buscar el elemento.
            NodoGen buscado = obtenerNodo(elemento, this.raiz);
            if (buscado != null) {
                pertenece = true;
            }
        }
        return pertenece;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    public String toStringAux(NodoGen nodo) {
        String cadena = "";
        if (nodo != null) {
            cadena += nodo.getElemento().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                cadena += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                cadena += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return cadena;
    }

    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInOrdenAux(this.raiz, salida);
        return salida;
    }

    private void listarInOrdenAux(NodoGen nodo, Lista salida) {
        if (nodo != null) {
            //llamo recursivamente con primer hijo de nodo
            if (nodo.getHijoIzquierdo() != null) {
                listarInOrdenAux(nodo.getHijoIzquierdo(), salida);
            }

            //visita del el nodo
            salida.insertar(nodo.getElemento(), salida.longitud() + 1);

            //llamados recursivos con los otros hijos del nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInOrdenAux(hijo, salida);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public int altura() {
        int niveles = -1;

        if (!this.esVacio()) {
            niveles = alturaAux(this.raiz, 0);
        }

        return niveles;
    }

    public int alturaAux(NodoGen nodo, int nivel) {

        if (nodo != null) {
            // Si tiene hermano lo revisamos con la misma altura
            int hermano = alturaAux(nodo.getHermanoDerecho(), nivel);
            // Cada vez que baja a un hijo la altura aumenta en 1
            if (nodo.getHijoIzquierdo() != null) {
                nivel = alturaAux(nodo.getHijoIzquierdo(), nivel + 1);
            }
            // Si el contador de algun hermano es mayor usamos ese
            if (hermano > nivel) {
                nivel = hermano;
            }
        }

        return nivel;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        //Si no esta vacio, clona la raiz.
        if (this.raiz != null) {
            clon.raiz = new NodoGen(this.raiz.getElemento(), null, null);
            clonAux(this.raiz, clon.raiz);
        }
        return clon;
    }

    public void clonAux(NodoGen original, NodoGen clon) {
        //Recorremos el arbol recursivamente en pre-orden.
        if (clon != null) {
            //Verifica que hijoIzquierdo no sea null
            if (original.getHijoIzquierdo() != null) {
                //Recorre y clona los hijos izquierdos
                clon.setHijoIzquierdo(new NodoGen(original.getHijoIzquierdo().getElemento(), null, null));
                clonAux(original.getHijoIzquierdo(), clon.getHijoIzquierdo());
            }
            // Verifica que hermanoDerecho no sea null
            if (original.getHermanoDerecho() != null) {
                // Recorre y clona hermanos derechos.
                clon.setHermanoDerecho(new NodoGen(original.getHermanoDerecho().getElemento(), null, null));
                clonAux(original.getHermanoDerecho(), clon.getHermanoDerecho());
            }
        }

    }

    public Lista listarPreorden() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            preOrdenAux(l1, this.raiz);
        }
        return l1;
    }

    private void preOrdenAux(Lista l1, NodoGen actual) {
        if (actual != null) {
            l1.insertar(actual.getElemento(), l1.longitud() + 1);
            preOrdenAux(l1, actual.getHijoIzquierdo());
            preOrdenAux(l1, actual.getHermanoDerecho());
        }

    }

    public Lista listarPosorden() {
        Lista l1 = new Lista();
        if (this.raiz != null) {
            posOrdenAux(l1, this.raiz);
        }
        return l1;
    }

    private void posOrdenAux(Lista l1, NodoGen actual) {
        if (actual != null) {
            posOrdenAux(l1, actual.getHijoIzquierdo());
            l1.insertar(actual.getElemento(), l1.longitud() + 1);
            posOrdenAux(l1, actual.getHermanoDerecho());
        }
    }

    public int nivel(Object unElemento) {
        //Ingresamos al metodo recursivo auxiliar.
        int nivel = nivelAux(unElemento, 0, this.raiz);
        return nivel;
    }

    private int nivelAux(Object unElemento, int nivel, NodoGen nodo) {
        //Recorremos el arbol por niveles.
        int res = -1;
        if (nodo != null) {
            //Mientras no lo encuentra, entra.
            if (!(unElemento.equals(nodo.getElemento()))) {
                //Nos deplazamos por los hermanos derechos.
                res = nivelAux(unElemento, nivel, nodo.getHermanoDerecho());
                if (res == -1) { //Si es -1, no lo encontro.
                    //Recorre los hijos izquierdos.
                    res = nivelAux(unElemento, nivel + 1, nodo.getHijoIzquierdo());
                }
            } else {
                //Asignamos el nivel del elemento encontrado.
                res = nivel;
            }
        }
        return res;
    }

    public Object padre(Object elemento) {
        Object encontrado = null;
        if (this.raiz != null && !(this.raiz.getElemento().equals(elemento))) {
            encontrado = padreAux(elemento, this.raiz.getHijoIzquierdo(), this.raiz);
        }
        return encontrado;
    }

    private Object padreAux(Object elemento, NodoGen actual, NodoGen padre) {
        Object encontrado = null;
        if (actual != null) {
            /*Si el elemento del nodo actual(hijo) es igual al elemento,
            encontrado es donde esta parado el nodo "padre"*/
            if (actual.getElemento().equals(elemento)) {
                encontrado = padre.getElemento();
            } else {
                //Busca por los hijos izquierdos al elemento
                encontrado = padreAux(elemento, actual.getHijoIzquierdo(), actual);
                //Si no encuentra, busca por hermanos derechos.
                if (encontrado == null) {
                    encontrado = padreAux(elemento, actual.getHermanoDerecho(), padre);
                }
            }
        }
        return encontrado;
    }

    public Lista ancestros(Object elem) {
        Lista lista = new Lista();
        if (this.raiz != null) {
            ancestroAux(this.raiz, elem, lista);
        }
        return lista;
    }

    private boolean ancestroAux(NodoGen actual, Object elem, Lista lista) {
        boolean encontrado = false;
        if (actual != null) {
            //Comparamos elementos
            if (actual.getElemento().equals(elem)) {
                encontrado = true;
            } else {
                //Si no encuentra, ingresamos al hijo izquierdo
                encontrado = ancestroAux(actual.getHijoIzquierdo(), elem, lista);
                //Si lo encontramos, al salir, insertamos en la lista.
                if (encontrado) {
                    lista.insertar(actual.getElemento(), 1);
                } else { //Si aun no se encuentra, buscamos en hermanos derechos.
                    encontrado = ancestroAux(actual.getHermanoDerecho(), elem, lista);
                }

            }
        }
        return encontrado;
    }

    public Lista listarPorNiveles() {
        Lista resultado = new Lista();
        if (this.raiz != null) {
            listarNivelesAux(this.raiz, resultado);
        }
        return resultado;
    }

    private void listarNivelesAux(NodoGen actual, Lista res) {
        Cola auxCola = new Cola();
        //Coloca la raiz en la cola
        auxCola.poner(actual);
        while (!(auxCola.esVacia())) {
            //Se castea el frente de la cola, porque guarda tipo Object.
            //Guardamos el nodo del frente, en un nodo auxiliar.
            NodoGen nodo = (NodoGen) auxCola.obtenerFrente();
            auxCola.sacar();

            //Insertamos el elemento del nodo auxiliar en la lista.
            res.insertar(nodo.getElemento(), res.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            //Recorremos los hermanos derechos de un nivel
            while (hijo != null) {
                auxCola.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

//Frontera castillo
    
    public boolean sonFrontera(Lista l1) {
        //Precondicion, la lista que entra no tiene elementos repetidos.
        boolean exito = false;
        if (this.raiz != null && !(l1.esVacia())) {
            Lista l2 = l1.clone(); //Clon de lista original para romperla
            fronteraAux(this.raiz, l2);
            if (l2.esVacia()) { //Si el clon queda vacio, es porque todos los elementos estan en la frontera.
                exito = true;
            }
        }
        return exito;
    }

    private void fronteraAux(NodoGen actual, Lista lista) {
        if (actual != null && !(lista.esVacia())) {
            if (actual.getHijoIzquierdo() == null) {
                // Si es hoja, buscamos el elemento en la lista
                int buscar = lista.localizar(actual.getElemento());
                if (buscar != -1) { // Si lo encuentra lo elimina de la lista
                    lista.eliminar(buscar);
                }
            }
            //Recorre el arbol en pre-orden.
            fronteraAux(actual.getHijoIzquierdo(), lista);
            fronteraAux(actual.getHermanoDerecho(), lista);
        }
    }
//Frontera Mellado  
    /*
    public boolean sonFrontera(Lista lista) {
        boolean exito = false;
        Lista clon = lista.clone();
        if (!(lista.esVacia()) && this.raiz != null) {
            sonFronteraAux(this.raiz, clon);
            if (clon.esVacia()) {
                exito = true;
            }
        }

        return exito;
    }
    
    private void sonFronteraAux(NodoGen nodo, Lista lista) {
        // Precondición: lista no debe tener elementos repetidos

        if (nodo != null) {
            if (nodo.getHijoIzquierdo() == null) {
                // Si es un hijo verificamos que pertenezca a la lista
                lista.eliminar(lista.localizar(nodo.getElemento()));
            }
            if (!lista.esVacia()) {
                // Recorrido en preorden
                sonFronteraAux(nodo.getHijoIzquierdo(), lista);
                sonFronteraAux(nodo.getHermanoDerecho(), lista);
            }
        }
    }*/
}
