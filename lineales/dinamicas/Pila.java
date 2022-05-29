/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @Jesus Castillo FAI-2602
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object unElemento) {
        // Crea un nuevo nodo y lo enlaza al anterior
        Nodo nuevo = new Nodo(unElemento, this.tope);

        //Hace que el nuevo nodo sea el tope.
        this.tope = nuevo;

        // Retorna siempre true porque no hay problemas con el uso de memoria
        return true;
    }

    public boolean desapilar() {
        boolean exito;
        //Pregunta si la pila no esta vacía
        if (this.tope != null) {
            //Enlaza el tope con el nodo siguiente al tope.
            this.tope = this.tope.getEnlace();
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Retorna el elemento del nodo tope actual
        Object elemento = null;
        if (this.tope != null) {
            elemento = this.tope.getElemento();
        }
        return elemento;
    }

    public boolean esVacia() {
        boolean estaVacia = true;
        if (this.tope != null) {
            estaVacia = false;
        }
        return estaVacia;
    }

    public void vaciar() {
        this.tope = null; //El  recolector de basura se encarga de llevarse los elementos.Depende del LENGUAJE.
    }

    public Pila clone() {
        Pila clon = new Pila();
        Nodo aux = this.tope;
        Nodo auxClon;
        if (!esVacia()) {
            Nodo nuevo = new Nodo(aux.getElemento(), null);
            clon.tope = nuevo; //Hace que el tope apunte al nuevo nodo.
            auxClon = clon.tope; // el auxiliar del clon se para en el tope (nuevo)

            aux = aux.getEnlace(); //accede al siguiente nodo (pila original)
            while (aux != null) {
                //Crea el siguiente nodo
                nuevo = new Nodo(aux.getElemento(), null);

                auxClon.setEnlace(nuevo);
                auxClon = auxClon.getEnlace();
                aux = aux.getEnlace();

            }
        }
        return clon;
    }

    public String toString() {
        String cadena = "";
        if (!(esVacia())) {
            Nodo aux = this.tope;
            cadena = "[";
            while (aux != null) {
                cadena = cadena + aux.getElemento().toString();
                aux = aux.getEnlace();
            }
            cadena = cadena + "]";
        }
        return cadena;
    }
}
