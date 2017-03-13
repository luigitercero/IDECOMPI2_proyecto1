/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ParserTree;

import com.CompiladorHaskellPlusPlus.Gramaticas._Token;
import java.util.ArrayList;

/**
 *
 * @author luigitercero
 */
public class NodeTree {

    
  
   public Term term;
   public Token token;
    public ArrayList<NodeTree> childNode ;
    
public NodeTree(Term term, Token token) {
   this. term = term;
   this.token = token;
   this.childNode = new  ArrayList<NodeTree>();
   }

public NodeTree(Term term) {
   this. term = term;
   this.childNode = new  ArrayList<NodeTree>();
   }

public NodeTree(Term term,ArrayList<NodeTree> childNode) {
   this. term = term;
   this.token = null;
   this.childNode = childNode ;
    }


    
}
