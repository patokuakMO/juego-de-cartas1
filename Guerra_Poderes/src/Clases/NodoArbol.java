/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ISLENA
 */


public class NodoArbol {
    private String valor;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(String valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public NodoArbol getIzquierda() { return izquierda; }
    public void setIzquierda(NodoArbol izquierda) { this.izquierda = izquierda; }

    public NodoArbol getDerecha() { return derecha; }
    public void setDerecha(NodoArbol derecha) { this.derecha = derecha; }
}

