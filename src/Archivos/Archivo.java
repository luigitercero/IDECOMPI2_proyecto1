/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author luigitercero
 */
public class Archivo {

    private File archivo;

    public File getArchivo() {
        return archivo;
    }

    
    
    public Archivo() {
    }

    public void abrirArchivo() {//file choser
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new Filtro("txt"));
        selector.setDialogTitle("Leer Archivo");
        selector.setFileSelectionMode(0);
        int opcion = selector.showOpenDialog(selector);
        selector.setVisible(true);

        if (JFileChooser.APPROVE_OPTION == opcion) {
            File archivo = selector.getSelectedFile();
            this.archivo = archivo;

        }

    }

    public String getContenido() throws FileNotFoundException, IOException {
        String contenido = "";
        FileReader fr = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(fr);
        String linea = lector.readLine();
        while (linea != null) {
            contenido += linea + "\n";
            linea = lector.readLine();
        }
        lector.close();
        fr.close();
        return contenido;
    }

    public void guardarArchivo( String contenido) throws IOException {

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new Filtro("txt"));
        selector.setDialogTitle("Leer Archivo");
        selector.setFileSelectionMode(0);
        int opcion = selector.showSaveDialog(selector);
        selector.setVisible(true);
       
        if (JFileChooser.APPROVE_OPTION == opcion) {
            File archivo = selector.getSelectedFile();
            this.archivo = archivo;

        }

        FileWriter writer = new FileWriter(archivo, false);

        try {
            writer.write(contenido);
            writer.close();

        } catch (IOException ex) {
            // Logger.getLogger(ListaDoblementeEnalazada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
