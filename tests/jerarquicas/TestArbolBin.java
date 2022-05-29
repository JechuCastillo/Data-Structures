/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import Jerarquicas.ArbolBin;

/**
 *
 * @author Admin
 */
public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin unArbol = new ArbolBin();
        ArbolBin clon;
        unArbol.insertar(1, 3, 'i');
        unArbol.insertar(2, 1, 'i');
        unArbol.insertar(3, 2, 'i');
        unArbol.insertar(4, 2, 'd');
        unArbol.insertar(12, 1, 'd');

        System.out.println(unArbol.padre(5));
        System.out.println(unArbol.listarPreorden().toString());
        clon = unArbol.clone();
        unArbol.insertar(45, 12, 'd');
        System.out.println(unArbol.toString());
        System.out.println(unArbol.listarPreorden().toString());
        System.out.println(unArbol.listarPorNiveles().toString());
        System.out.println(unArbol.nivel(3));
        
    }
}
