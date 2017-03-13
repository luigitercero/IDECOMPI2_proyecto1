/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import javax.swing.filechooser.FileFilter;

/**
 *
 * @author luigitercero
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author chato
 */
public class Filtro extends javax.swing.filechooser.FileFilter {

    String extension;

    public Filtro(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(java.io.File f) {
        String s = f.getName();
        if (f.isDirectory()) {
            return true;
        }
        if (f.getName().endsWith(extension)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return ("." + extension);
    }
}

