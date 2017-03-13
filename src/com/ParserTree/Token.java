/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ParserTree;

/**
 *
 * @author luigitercero
 */
public class Token {

    public Location getLocation() {
        return location;
    }

    public String getValueString() {
        return valueString;
    }

    public int getTipo() {
        return Tipo;
    }
    
   
    private Location location ;
    private String valueString;
    private Object value;
    private int Tipo;
    
    public Token(Location location, Object valor, int tipo){
        this.location = location;
        this.value = valor;
        this.valueString = (String)valor;
        this.Tipo = tipo;
    }
    public Token(Location location, Object valor){
        this.location = location;
        this.value = valor;
        this.valueString = (String)valor;
        
    }
   
    
    
}
