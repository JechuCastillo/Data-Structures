/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.*;

/**
 *
 * @author Admin
 */
public class TestCadenas {

    public static void main(String[] args) {
        Cola c1 = armarCola();
        //Cola c2 = generar2(c1);
        //System.out.println(c2.toString());
        System.out.println(verificarBalance(c1));

    }

    public static boolean verificarBalance(Cola c1) {
        boolean balanceada = true;
        Cola clon = c1.clone();
        Pila pilaAux = new Pila();
        //Mientras clon no esta vacia ejecuta
        while (!(clon.esVacia()) && balanceada) {
            //Si hay una expresion que abre, la apila
            if (llaveAbre(clon.obtenerFrente())) {
                pilaAux.apilar(clon.obtenerFrente());
                clon.sacar();
            } else if (llaveCierra(clon.obtenerFrente())) { // Si es una expresion que cierra
                //Si el tope de la pila es es la pareja del que cierra, desapila.
                if (!(pilaAux.esVacia()) && pilaAux.obtenerTope().equals(pareja(clon.obtenerFrente()))) {
                    pilaAux.desapilar();
                    clon.sacar();
                } else {
                    balanceada = false;
                }
            }
            clon.sacar();
        }
        //Si la pila aun tiene elementos, no esta bien balanceada
        if (pilaAux.esVacia()) {
            balanceada = false;
        }
        return balanceada;
    }

    public static Cola armarCola() {
        Cola c1 = new Cola();
        c1.poner(']');
        c1.poner('(');
        c1.poner('+');
        c1.poner('3');
        c1.poner(')');
        c1.poner('*');
        c1.poner('2');
        c1.poner('[');
        return c1;
    }

    public static boolean llaveAbre(Object tope) {
        return tope.equals('(') || tope.equals('[') || tope.equals('{');
    }

    public static boolean llaveCierra(Object tope) {
        return tope.equals(')') || tope.equals(']') || tope.equals('}');
    }

    public static char pareja(Object frente) {
        char res = '(';
        if (frente.equals(']')) {
            res = '[';
        } else if (frente.equals('}')) {
            res = '{';
        }
        return res;
    }

    public static Cola generar(Cola c1) {
        Cola colaAux = new Cola();
        Pila unaPila = new Pila();
        Cola clonCola = c1.clone();
        Lista unaLista = new Lista();
        int i = 1;
        while (!(clonCola.esVacia())) {
            i = 1;
            while (!(clonCola.esVacia()) && !(clonCola.obtenerFrente().equals('#'))) {
                unaPila.apilar(clonCola.obtenerFrente());
                unaLista.insertar(clonCola.obtenerFrente(), i);
                colaAux.poner(clonCola.obtenerFrente());
                clonCola.sacar();
                i++;
            }
            clonCola.sacar();
            boolean completa = false;
            while (!completa) {
                if (!(unaPila.esVacia())) {
                    colaAux.poner(unaPila.obtenerTope());
                    unaPila.desapilar();
                } else if (!(unaLista.esVacia())) {
                    colaAux.poner(unaLista.recuperar(1));
                    unaLista.eliminar(1);
                } else {
                    if (!(clonCola.esVacia())) {
                        colaAux.poner('#');
                    }
                    completa = true;
                }
            }
        }

        return colaAux;
    }

    public static Cola generar2(Cola c1) {

        Cola clon = c1.clone();
        Cola nueva = new Cola();

        if (!clon.esVacia()) {
            Pila pila = new Pila();
            Lista lista = new Lista();
            int pos = 0;
            Object aux = clon.obtenerFrente();
            while (aux != null) {
                if ((char) aux == '#') {
                    while (!pila.esVacia()) {
                        nueva.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    while (!lista.esVacia()) {
                        nueva.poner(lista.recuperar(1));
                        lista.eliminar(1);
                        pos--;
                    }
                    nueva.poner('#');
                } else {
                    pila.apilar(aux);
                    lista.insertar(aux, pos + 1);
                    nueva.poner(aux);
                    pos++;
                }
                clon.sacar();
                aux = clon.obtenerFrente();
            }
            while (!pila.esVacia()) {
                nueva.poner(pila.obtenerTope());
                pila.desapilar();
            }
            while (!lista.esVacia()) {
                nueva.poner(lista.recuperar(1));
                lista.eliminar(1);
            }
        }
        return nueva;

    }
}
