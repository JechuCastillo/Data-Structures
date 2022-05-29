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
public class HeapMin {

    private static final int tamanio = 11;
    private Comparable heap[];
    private int ultimo;

    public HeapMin() {
        this.heap = new Comparable[tamanio];
        this.ultimo = 0; //la posicion 0 no se utiliza
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        int longitud = heap.length - 1;
        if (this.ultimo == 0) { //Si esta vacio insertamos en posicion 1
            this.heap[1] = elemento;
            this.ultimo++;
        } else {
            //mientras ultimo es menor a la longitud(11)
            if (this.ultimo < longitud) {
                heap[ultimo + 1] = elemento;
                ultimo++;
                subir();
                exito = true;
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private void subir() {
        int padre = this.ultimo / 2; //Posicion del padre
        int hijo = this.ultimo; //Posicion de hijo
        //Mientras el hijo no llegue a la raiz y que el hijo sea menor que su padre, intercambiamos elementos.
        while (hijo > 1 && this.heap[hijo].compareTo(this.heap[padre]) < 0) {
            Comparable temp = this.heap[hijo];
            this.heap[hijo] = this.heap[padre];
            this.heap[padre] = temp;
            //Luego del intercambio
            hijo = padre; //Reposicionamos el hijo para seguir comparando
            padre = padre / 2; //Reposicionamos el padre para seguir comparando
        }

    }

    public HeapMin clone() {
        HeapMin clon = new HeapMin();//creamos el clon
        clon.heap = this.heap.clone();//Copiamos el array del arbol
        clon.ultimo = this.ultimo; //copiamos la ultima posicion
        return clon;
    }

    public String toString() {
        String cadena = "";
        int i;
        for (i = 1; i <= this.ultimo; i++) {
            cadena = cadena + " " + (Object) this.heap[i];
        }
        return cadena;
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public void vaciar() {
        if (this.ultimo != 0) {
            for (int i = 1; i <= this.ultimo; i++) {
                this.heap[i] = null;
            }
            this.ultimo = 0;
        }
    }

    public Object recuperarCima() {
        Object elemento = null;
        if (this.ultimo != 0) {
            elemento = this.heap[1];
        }
        return elemento;
    }

    public boolean eliminarCima() {
        boolean exito = true;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //Reestablece la propiedad del heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    public void hacerBajar(int posPadre) {
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            int posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //temp tiene al menos un hijo y lo considera menor
                if (posH < this.ultimo) {
                    //hijoMenor tiene hermano derecho
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        posH++;
                    }
                }

                //Compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    //El hijo es menor que el padre, lo intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    //El padre es menor que sus hijos, esta bien ubicado.
                    salir = true;
                }

            } else {
                //el temp es hoja y esta bien ubicado
                salir = true;
            }
        }
    }
}
