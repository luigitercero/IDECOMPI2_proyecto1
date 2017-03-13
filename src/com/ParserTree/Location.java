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
public class Location {
    public int Column;

    public int getColumn() {
        return Column;
    }

    public int getLine() {
        return Line;
    }
    public int Line;
    
   public Location (int column, int line){
       this.Column = column;
       this.Line = line;
   }
}
