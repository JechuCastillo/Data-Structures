/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import Jerarquicas.ArbolGen;
import java.util.Scanner;
import lineales.dinamicas.Lista;

/**
 *
 * @author Admin
 */
public class testMellado {

    public static void main(String args[]) {
        ArbolGen unArbol = new ArbolGen();
        unArbol.insertar(1, 1);
        unArbol.insertar(2, 1);
        unArbol.insertar(3, 1);
        unArbol.insertar(4, 2);
        unArbol.insertar(5, 2);
        unArbol.insertar(6, 2);
        unArbol.insertar(10, 5);
        unArbol.insertar(7, 1);

        Lista l1 = new Lista();
        pruebas(unArbol, l1);
    }

    public static void menu() {
        System.out.println("1- lista de vacia");
        System.out.println("2- lista con algunos elementos de frontera");
        System.out.println("3- lista con todos los de la frontera");
        System.out.println("4- lista con un elemento diferente");
        System.out.println("5- lista con elementos diferentes de frontera");
        System.out.println("6- arbol vacio");
    }

    public static void pruebas(ArbolGen arbol, Lista l1) {

        Scanner sc = new Scanner(System.in);
        char salir = 'n';
        int op;
        menu();
        while (salir != 's') {
            System.out.println("ingrese una opcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("lista vacia debe dar false: " + arbol.sonFrontera(l1));
                    break;
                case 2:
                    l1.insertar(4, 1);
                    l1.insertar(7, 2);
                    l1.insertar(6, 3);
                    System.out.println("debe dar True-->" + arbol.sonFrontera(l1));
                    l1.vaciar();
                    break;

                case 3:
                    l1.insertar(4, 1);
                    l1.insertar(7, 2);
                    l1.insertar(6, 3);
                    l1.insertar(10, 4);
                    l1.insertar(3, 5);
                    System.out.println("debe dar True-->" + arbol.sonFrontera(l1));
                    l1.vaciar();
                    break;

                case 4:
                    l1.insertar(4, 1);
                    l1.insertar(7, 2);
                    l1.insertar(6, 3);
                    l1.insertar(10, 4);
                    l1.insertar(3, 5);
                    l1.insertar(12, 5);
                    System.out.println("debe dar false-->" + arbol.sonFrontera(l1));
                    l1.vaciar();

                    break;

                case 5:
                    l1.insertar(9, 1);
                    l1.insertar(6, 2);
                    l1.insertar(11, 3);
                    l1.insertar(33, 4);
                    l1.insertar(12, 5);
                    System.out.println("debe dar false-->" + arbol.sonFrontera(l1));
                    l1.vaciar();

                    break;

                case 6:
                    ArbolGen vacio = new ArbolGen();
                    l1.insertar(4, 1);
                    l1.insertar(7, 2);
                    l1.insertar(6, 3);
                    l1.insertar(10, 4);
                    l1.insertar(3, 5);
                    System.out.println("debe dar False-->" + vacio.sonFrontera(l1));
                    l1.vaciar();

                    break;

                default:
                    System.out.println("ERror");
                    break;

            }
            System.out.println("desea salir? s/n");
            salir = sc.next().charAt(0);
        }
    }
}
