/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ParserTree;

import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author luigitercero
 */
public class ParserTree {

    public NodeTree root;

    public ParserTree(NodeTree nodo) {
        root = nodo;
    }

    
    public void addChild(NodeTree pa, NodeTree child) {
        pa.childNode.add(child);

    }

    public void addChildren(NodeTree pa, ArrayList<NodeTree> childNode) {
        pa.childNode = childNode;

    }

    public void addChildren(NodeTree... child) {
        for (int i = 0; i < child.length; i++) {
            this.root.childNode.add(child[i]);
        }
    }
    int contador =0;
    public void Arbol_listar_enlazar(NodeTree nodo, int num){
        
        
            if (nodo != null)
            {
                System.out.println(nodo.term.getName());
                int tam = nodo.childNode.size();
                int actual;
                for (int i = 0; i < tam; i++)
                {
                    contador = contador + 1;
                    actual = contador;
                    Arbol_listar_enlazar(nodo.childNode.get(i), contador);
                    
                }
            }
        
    }

}
