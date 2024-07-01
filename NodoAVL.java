/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinamicas;

/**
 *
 * @author Mati
 */
public class NodoAVL {

    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(Comparable el, NodoAVL izq, NodoAVL der) {
        this.elem = el;
        this.izquierdo = izq;
        this.derecho = der;
    }
    
    public NodoAVL(Comparable el) {
        this.elem = el;
    }
    
    public int getAltura() {
        return 0;
    }
    
    public void recalcularAltura() {
        
    }

    public Comparable getElem() {
        return this.elem;
    }

    public void setElem(Comparable el) {
        elem = el;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(NodoAVL izq) {
        izquierdo = izq;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    public void setDerecho(NodoAVL der) {
        derecho = der;
    }
}
