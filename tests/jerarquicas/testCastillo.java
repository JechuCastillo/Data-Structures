/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import Jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author Admin
 */
public class testCastillo {

    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";

    public static void main(String[] args) {
        System.out.println("**** TEST METODO FRONTERA @CASTILLO JESUS****");
        System.out.println("****COMIENZA TEST PARA EL METODO CREADO POR MELLADO****");
        ArbolGen a = new ArbolGen();
        Lista l1 = new Lista();
        System.out.println("PRUEBA CON ARBOL VACIO Y LISTA VACIA");
        System.out.println("Espera " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("Inserto 1 en arbol:");
        a.insertar(1, l1.longitud() + 1);
        System.out.println(a.toString());
        System.out.println("PRUEBA LISTA VACIA");
        System.out.println("Espera " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("INSERTO 1 EN LISTA");
        l1.insertar(1, l1.longitud() + 1);
        System.out.println("LISTA:" + l1.toString());
        System.out.println("ESPERA " + sOk + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("INSERTO 2 EN LISTA");
        l1.insertar(2, l1.longitud() + 1);
        System.out.println(l1.toString());
        System.out.println("ESPERA " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("INSERTO 2, 3 , 4, 5 y 6 en ARBOL");
        a.insertar(2, 1);
        a.insertar(3, 1);
        a.insertar(4, 1);
        a.insertar(5, 1);
        a.insertar(6, 1);
        System.out.println(a.toString());
        System.out.println("LISTA:"+l1.toString());
        System.out.println("ESPERA " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("ELIMINO 1 DE LISTA Y PRUEBA:");
        l1.eliminar(1);
        System.out.println("LISTA:"+l1.toString());
        System.out.println("ESPERA " + sOk + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("INSERTO 3,4,5,6 EN LISTA");
        l1.insertar(3, l1.longitud() + 1);
        l1.insertar(4, l1.longitud() + 1);
        l1.insertar(5, l1.longitud() + 1);
        l1.insertar(6, l1.longitud() + 1);
        System.out.println("LISTA: " + l1.toString());
        System.out.println("ESPERA " + sOk + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("VACIA EL ARBOL Y COLOCA NUEVOS ELEMENTOS");
        a.vaciar();
        a.insertar(1, 1);
        a.insertar(2, 1);
        a.insertar(3, 1);
        a.insertar(7, 1);
        a.insertar(4, 2);
        a.insertar(5, 2);
        a.insertar(6, 2);
        a.insertar(10, 5);
        a.insertar(11, 5);
        a.insertar(12, 7);
        a.insertar(14, 7);
        System.out.println("ARBOL:\n" + a.toString());
        System.out.println("ESPERA " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("VACIA LISTA Y COLOCA NUEVA FRONTERA");
        l1.vaciar();
        l1.insertar(4, 1);
        l1.insertar(10, 1);
        l1.insertar(11, 1);
        l1.insertar(6, 1);
        l1.insertar(3, 1);
        l1.insertar(12, 1);
        l1.insertar(14, 1);
        System.out.println("LISTA: " + l1.toString());
        System.out.println("ESPERA " + sOk + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("AGREGA EXTRAS A LA LISTA");
        l1.insertar(203, 1);
        l1.insertar(84, 1);

        System.out.println("LISTA:"+l1.toString());
        System.out.println("ESPERA " + sErr + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("ELIMINO ELEMENTOS DE LA LISTA");
        l1.eliminar(1);
        l1.eliminar(1);
        l1.eliminar(1);
        l1.eliminar(1);
        l1.eliminar(1);
        System.out.println("LISTA: "+l1.toString());
        System.out.println("ESPERA " + sOk + ": " + (a.sonFrontera(l1) ? sOk : sErr));
        System.out.println("----------------------- FIN TEST --------------------------");
    }
}
