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
public class Nodo {
    //Atributo
    private Object elemento;
    private Nodo enlace;
    
    //
    public Nodo(Object unElemento,Nodo unEnlace){
        this.elemento=unElemento;
        this.enlace=unEnlace;
    }
    //Observadores
    public Object getElemento(){
        return this.elemento;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
    
    //Modificadores
    public void setElemento(Object unElemento){
        this.elemento=unElemento;
    }
    public void setEnlace(Nodo unEnlace){
        this.enlace=unEnlace;
    }
}
