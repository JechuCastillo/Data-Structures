/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

//import lineales.estaticas.Cola;
import lineales.dinamicas.Cola;

/**
 *
 * @author Admin
 */
public class TestCola {

    static String sOk = "OK", sErr = "ERRAWR";

    public static void main(String args[]) {
        // testCola();
        Cola unaCola = new Cola();
        int i;
        for (i = 1; i < 11; i++) {
            unaCola.poner(i);
        }
        System.out.println("Cola vacia espera false:" + unaCola.esVacia());
        Cola clon = unaCola.clone();
        clon.poner(3);
        System.out.println(unaCola.toString());
        unaCola.sacar();
        System.out.println(unaCola.toString());
        unaCola.vaciar();
        System.out.println("Intenta sacar con cola vacia espera false: "+unaCola.sacar());
        System.out.println(unaCola.toString());
        System.out.println("Cola vacia espera true:" + unaCola.esVacia());
        System.out.println(clon.toString());
        System.out.println((int) clon.obtenerFrente());
    }

    public static void testCola() {
        System.out.println("COMIENZA EL TEST");
        Cola c1 = new Cola();
        System.out.println("\t\t\t\t\t\t\t\t--> " + c1.toString());
        System.out.println("Pone 1 espera TRUE y [1]:\t\t\t\t" + ((c1.poner(1)) ? sOk : sErr));
        System.out.println("Pone 2 espera TRUE y [2]:\t\t\t\t" + ((c1.poner(2)) ? sOk : sErr));
        System.out.println("Pone 3 espera TRUE y [3]:\t\t\t\t" + ((c1.poner(3)) ? sOk : sErr));
        System.out.println("Pone 4 espera TRUE y [4]:\t\t\t\t" + ((c1.poner(4)) ? sOk : sErr));
        System.out.println("Pone 5 espera TRUE y [5]:\t\t\t\t" + ((c1.poner(5)) ? sOk : sErr));
        System.out.println("Pone 6 espera TRUE y [6]:\t\t\t\t" + ((c1.poner(6)) ? sOk : sErr));
        System.out.println("Pone 7 espera TRUE y [7]:\t\t\t\t" + ((c1.poner(7)) ? sOk : sErr));
        System.out.println("Pone 8 espera TRUE y [8]:\t\t\t\t" + ((c1.poner(8)) ? sOk : sErr));
        System.out.println("Pone 9 espera TRUE y [9]:\t\t\t\t" + ((c1.poner(9)) ? sOk : sErr));
        System.out.println("Pone 10 espera false en estatica y TRUE en dinamica:\t\t\t\t" + c1.poner(10));
        System.out.println(c1.toString());

    }
}
