/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.conjuntistas;

import conjuntistas.HeapMin;

/**
 *
 * @author Admin
 */
public class testHeapMin {

    public static void main(String[] args) {
        HeapMin unHeap = new HeapMin();
        unHeap.insertar(16);
        unHeap.insertar(1);
        unHeap.insertar(12);
        unHeap.insertar(6);
        unHeap.insertar(8);
        unHeap.insertar(4);
        unHeap.insertar(3);
        unHeap.insertar(-3);
        unHeap.insertar(-3);
        System.out.println(unHeap.insertar(-3));

        System.out.println(unHeap.insertar(-3));
        HeapMin otroHeap = unHeap.clone();

        System.out.println(otroHeap.toString());
        otroHeap.vaciar();

    }

}
