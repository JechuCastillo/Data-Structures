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
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elemento) {
        boolean exito = true;
        //Si el elemento esta repetido no lo inserta
        if (elemento.compareTo(nodo.getElemento()) == 0) {
            exito = false;
        } else {
            //Si el elemento es menor a la raiz, prepara la insercion por izquierda.
            if (elemento.compareTo(nodo.getElemento()) < 0) {
                if (nodo.getIzquierdo() == null) {//Si no hay hijo izquierdo lo inserta
                    nodo.setIzquierdo(new NodoABB(elemento, null, null));
                } else { //Si ya existe un hijo izquierdo avanza hacia el y hace las mismas comparaciones
                    exito = insertarAux(nodo.getIzquierdo(), elemento);
                }
            } else {
                //Si no hay hijo derecho lo inserta
                if (nodo.getDerecho() == null) {
                    nodo.setDerecho(new NodoABB(elemento, null, null));
                } else { //Si hay hijo derecho, recorre.
                    exito = insertarAux(nodo.getDerecho(), elemento);
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Comparable elemento) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elemento) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) == 0) {
                exito = true;
            } else {
                if (elemento.compareTo(nodo.getElemento()) < 0) {
                    exito = perteneceAux(nodo.getIzquierdo(), elemento);
                } else {
                    exito = perteneceAux(nodo.getDerecho(), elemento);
                }
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public boolean eliminar(Comparable elemento) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = eliminarAux(this.raiz, elemento);
        }
        return exito;
    }

    public NodoABB obtenerNodo(NodoABB actual, Comparable elto) {
        NodoABB padre = null;
        if (actual != null) {
            if (elto.compareTo(actual.getElemento()) < 0) {
                if (actual.getIzquierdo().getElemento().compareTo(elto) == 0) {
                    padre = actual;
                } else {
                    padre = obtenerNodo(actual.getIzquierdo(), elto);
                }

            } else {
                if (actual.getDerecho().getElemento().compareTo(elto) == 0) {
                    padre = actual;
                } else {
                    padre = obtenerNodo(actual.getDerecho(), elto);
                }
            }

        }
        return padre;
    }

    private boolean eliminarAux(NodoABB actual, Comparable elemento) {
        boolean exito = false;
        if (actual != null) {
            //Caso de eliminar raiz
            if (actual.getElemento().compareTo(elemento) == 0) {
                eliminarRaiz(this.raiz);
            }
        }
        return exito;
    }

    private void verificarCaso(NodoABB actual, Comparable elto) {

    }

    private void eliminarRaiz(NodoABB actual) {
        if (actual.getIzquierdo() != null) {
            NodoABB nuevo = obtenerMaximoIzquierdo(actual.getIzquierdo());
            nuevo.setDerecho(actual.getDerecho());
            nuevo.setIzquierdo(actual.getDerecho());
            actual = nuevo;
        } else {
            if (actual.getDerecho() != null) {
                NodoABB nuevo = obtenerMinimoDerecho(actual.getDerecho());
                nuevo.setDerecho(actual.getDerecho());
                nuevo.setIzquierdo(actual.getDerecho());
                actual = nuevo;
            }
        }
    }

    private NodoABB obtenerMaximoIzquierdo(NodoABB subIzq) {
        NodoABB maximo = null;
        if (subIzq != null) {
            if (subIzq.getDerecho() == null) {
                maximo = new NodoABB(subIzq.getElemento(), null, null);
                subIzq = null;
            } else {
                maximo = obtenerMaximoIzquierdo(subIzq.getDerecho());
            }
        }
        return maximo;
    }

    private NodoABB obtenerMinimoDerecho(NodoABB subDer) {
        NodoABB minimo = null;
        if (subDer != null) {
            if (subDer.getIzquierdo() == null) {
                minimo = new NodoABB(subDer.getElemento(), null, null);
                subDer = null;
            } else {
                minimo = obtenerMinimoDerecho(subDer.getIzquierdo());
            }
        }
        return minimo;
    }

}
