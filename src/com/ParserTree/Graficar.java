/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ParserTree;

import Archivos.Filtro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author luigitercero
 */
public class Graficar {

    public String desktop;
    private StringBuilder graphivz;
    private int contador;

    public void graficar(ParserTree arbol) {
        graphivz = new StringBuilder();
        contador = 0;
        desktop = System.getProperty("user.home");
        System.out.println("el escritorio es " + desktop );
        String rdot = desktop + "\\Pictures\\Arbol\\arbol.dot";
        System.out.println("el escritorio es " + rdot );
        String rpng = desktop + "\\Pictures\\Arbol\\arbol.png";
        graphivz.append("digraph G {\r\n node[ style=filled, color=khaki1, fontcolor=black]; \r\n");
        Arbol_listar_enlazar(arbol.root, contador);
        graphivz.append("}");
        
        this.crearImagen(rdot, rpng);
       
    }

    private void Arbol_listar_enlazar(NodeTree nodo, int num) {
        if (nodo != null) {
            graphivz.append("node" + num + " [ label = \"" + nodo.term.getName() + "\"];\r\n");
            int tam = nodo.childNode.size();
            int actual;
            for (int i = 0; i < tam; i++) {
                contador = contador + 1;
                actual = contador;
                Arbol_listar_enlazar(nodo.childNode.get(i), contador);
                graphivz.append("\"node" + num + "\"->\"node" + actual + "\";\r\n");
            }
        }
    }

    protected String crearImagen(String rdot, String rpng ) {
        try {
            
            FileWriter writer = new FileWriter(rdot, false);
            try {
            writer.write(graphivz.toString());
            writer.close();

        } catch (IOException ex) {
                System.out.println("no se creo el archivo");
        }
            
            String dotPath = "C:\\Program Files (x86)\\Graphviz-2.38\\release\\bin\\dot.exe";//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String fileInputPath = rdot;//path del archivo creado con el codigo del graphviz que querem
            String fileOutputPath = rpng;//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String tParam = "-Tpng";//tipo de imagen de salida, en este caso es jpg
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            //concatenamos nuestras direcciones. Lo que hice es crear un vector, para poder editar las direcciones de entrada y salida, usando las variables antes inicializadas
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
            //ABRIR EL ARCHIVO
            Runtime.getRuntime().exec("cmd /c start " + fileOutputPath);
            return fileOutputPath;
        } catch (IOException ex) {
           // Logger.getLogger(ListaDoblementeEnalazada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no se pudo guardar";
    }   
    
    
   

}
