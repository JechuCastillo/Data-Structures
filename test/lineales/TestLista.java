/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

/**
 *
 * @author Admin
 */
public class TestLista {

    public static void main(String[] args) {
        Lista l1 = new Lista();
        for (int i = 1; i <= 10; i++) {
            l1.insertar(i, i);
        }
        l1.insertar(1, 11);
        System.out.println(l1.toString());
        l1.eliminarApariciones(1);
        System.out.println(l1.toString());
        //System.out.println(comprobar(l1));
        //l1.eliminarApariciones(2);
        //Lista l2 = l1.obtenerMultiplos(3);
        // System.out.println(l2.toString());
        /*
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        Lista l3 = concatenar(l1, l2);
        System.out.println(l3);
         */
    }

    public static Lista concatenar(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        l3 = l1.clone();
        int ultima = l3.longitud() + 1;
        int longitud2 = l2.longitud();
        for (int i = 1; i <= longitud2; i++) {
            l3.insertar(l2.recuperar(i), ultima);
            ultima++;
        }
        return l3;
    }

    public static boolean comprobar(Lista l1) {
        boolean cumple = true;
        Cola unaCola = new Cola();
        Pila unaPila = new Pila();
        Lista l2 = l1.clone();
        int longitudColaYPila = 0;
        int i, longitud = l2.longitud();

        while ((int) l2.recuperar(1) != 0) {
            unaCola.poner(l2.recuperar(1));
            unaPila.apilar(l2.recuperar(1));
            l2.eliminar(1);
            longitudColaYPila++;
        }
        l2.eliminar(1);
        //System.out.println(l2.toString());
        cumple = comprobarMedio(l2, unaCola, longitudColaYPila);
        if (cumple) {
            cumple = comprobarFin(l2, unaPila, longitudColaYPila);
        }
        return cumple;
    }

    public static boolean comprobarMedio(Lista clon, Cola auxCola, int longitudCYP) {
        boolean resultado = true;
        int contador = 0;
        //Comprueba que se cumple el requisito hasta cadena0cadena0...
        while ((resultado && !auxCola.esVacia()) || (int) clon.recuperar(1) != 0) {
            contador++;
            if (contador > longitudCYP) {
                resultado = false;
            }
            //Si encuentra un elemento del medio de la lista distinto al del comienzo, es distinto
            if (clon.recuperar(1) != auxCola.obtenerFrente()) {
                resultado = false;
            }
            clon.eliminar(1);
            auxCola.sacar();

        }
        //Si la longitud de los elementos hasta el 0 es menor que la de la cola, no cumple.
        if (contador < longitudCYP) {
            resultado = false;
        }
        clon.eliminar(1);

        return resultado;
    }

    public static boolean comprobarFin(Lista clon, Pila auxPila, int longitudCYP) {
        boolean resultado = true;
        int contador = 0;

        //Comprueba que se cumple el requisito de que la ultima sea la cadena invertida
        while ((resultado && !auxPila.esVacia()) || !clon.esVacia()) {
            contador++;
            if (contador > longitudCYP) {
                resultado = false;
            } else if (auxPila.obtenerTope() != clon.recuperar(1)) {
                resultado = false;
            }
            clon.eliminar(1);
            auxPila.desapilar();

        }
        if (contador < longitudCYP) {
            resultado = false;
        }
        return resultado;
    }

    public static Lista invertir(Lista l1) {
        int longitud = l1.longitud();
        Pila aux = new Pila();
        Lista clon = l1.clone();
        int i;
        for (i = 1; i <= longitud; i++) {
            aux.apilar(clon.recuperar(1));
            clon.eliminar(1);
        }
        Lista invertida = new Lista();
        for (i = 1; i <= longitud; i++) {
            invertida.insertar(aux.obtenerTope(), i);
            aux.desapilar();
        }
        return invertida;
    }

}
