/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jesus
 */
public class Letra {
    private char letra;
    private char letra2;
    private Integer posicion;
    public Letra(char letra, char letra2, Integer posicion) {
        this.letra = letra;
        this.posicion = posicion;
        this.letra2 = letra2;
    }   

    public char getLetra2() {
        return letra2;
    }

    public void setLetra2(char letra2) {
        this.letra2 = letra2;
    }
    
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
    
    
}
