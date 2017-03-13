/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idecompi2_proyecto1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author luigitercero
 */
public class EstiloDocuments extends DefaultStyledDocument{

    private static final long serialVersionUID = 1L;
    private final StyleContext Estilo_Contexto = new StyleContext();
    private final Style Estilo_Cadenas = Estilo_Contexto.addStyle("ConstantWidth", null);
    private final Style Estilo_Identificador = Estilo_Contexto.addStyle("ConstantWidth", null);
    private final Style Estilo_Comentarios = Estilo_Contexto.addStyle("ConstantWidth", null);
    private final Style Estilo_Palabras_Reservadas = Estilo_Contexto.addStyle("ConstantWidth", null);
    private  boolean Case_Sensitive = true;

    public EstiloDocuments(Color Palabras_Reservadas, Color ID, Color Cadenas,Color Comentarios,  boolean CaseSensitive) {
        StyleConstants.setForeground(Estilo_Cadenas, Cadenas);
        StyleConstants.setForeground(Estilo_Identificador, ID);
        StyleConstants.setForeground(Estilo_Comentarios, Comentarios);
        StyleConstants.setForeground(Estilo_Palabras_Reservadas, Palabras_Reservadas);
        this.Case_Sensitive = CaseSensitive;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offset, str, a);
        refreshDocument();
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);
        refreshDocument();
    }

    private synchronized void refreshDocument() throws BadLocationException {
        String text = getText(0, getLength());
        final List<Palabras_Formato> list = processWords(text);

        setCharacterAttributes(0, text.length(), Estilo_Contexto.getStyle(StyleContext.DEFAULT_STYLE), true);
        for (Palabras_Formato word : list) {
            int p0 = word.Posicion_Inicio_Palabra;
            switch (word.Tipo_Palabra) {
                case 0:
                    setCharacterAttributes(p0, word.Palabra.length(), Estilo_Palabras_Reservadas, false);
                    break;
                case 1:
                    setCharacterAttributes(p0, word.Palabra.length(), Estilo_Cadenas, true);
                    break;
                case 2:
                    setCharacterAttributes(p0, word.Palabra.length(), Estilo_Identificador, true);
                    break;
                case 3:
                    setCharacterAttributes(p0, word.Palabra.length(), Estilo_Comentarios, true);
                    break;
                default:
                    break;
            }

        }
    }

    private  List<Palabras_Formato> processWords(String Texto) {
        Texto += " ";
        List<Palabras_Formato> palabras = new ArrayList<>();
        int Posicion_Separador_Anterior = 0;

        String Palabra_Formada = "";
        char[] data = Texto.toCharArray();

        for (int index = 0; index < data.length; index++) {
            char ch = data[index];
            if (Calcular_Delimitador(ch, Palabra_Formada)) {
                Posicion_Separador_Anterior = index;
                if (Palabra_Formada.length() > 0) {
                    if (esPalabraReservada(Palabra_Formada)) {
                        palabras.add(new Palabras_Formato(Palabra_Formada, (Posicion_Separador_Anterior - Palabra_Formada.length()), 0));
                    } else if (esCadena(Palabra_Formada)) {
                        palabras.add(new Palabras_Formato(Palabra_Formada, (Posicion_Separador_Anterior - Palabra_Formada.length()), 1));
                    } else if (esIdentificador(Palabra_Formada)) {
                        palabras.add(new Palabras_Formato(Palabra_Formada, (Posicion_Separador_Anterior - Palabra_Formada.length()), 2));
                    } else if (esComentario(Palabra_Formada)) {
                        palabras.add(new Palabras_Formato(Palabra_Formada, (Posicion_Separador_Anterior - Palabra_Formada.length()), 3));
                    } else if (esComentarioLineas(Palabra_Formada)) {
                        palabras.add(new Palabras_Formato(Palabra_Formada, (Posicion_Separador_Anterior - Palabra_Formada.length()), 3));
                    }

                    Palabra_Formada = "";
                }
            } else {
                Palabra_Formada += ch;
                if (Palabra_Formada.length() == 1 && !(Palabra_Formada.matches("[a-zA-Z]|\"|#|'"))) {
                    Palabra_Formada = "";
                }
            }
        }
        return palabras;
    }



    private  boolean Calcular_Delimitador(char ch, String Palabra_Formada) {
        /*
           linea 158 si viene espacio y no estamos dentro de una cadena comentario o char es un delimitador
           linea 159 si es una cadena
           linea 160 si es un salto de linea y no estamos en un comentario multilinea
           linea 161 si es un comentario multilineas
           linea 162 si es un identificador y al lado viene los deilitadores como (,),+,-,*,/,= etc
         */
        return (ch == ' ') && !(Palabra_Formada.startsWith("\"") || Palabra_Formada.startsWith("#") || Palabra_Formada.startsWith("'"))
                || esCadena(Palabra_Formada)
                || (ch == '\n') && !Palabra_Formada.startsWith("#/")
                || esComentarioLineas(Palabra_Formada)
                || esIdentificador(Palabra_Formada) && esDelimitador(ch);
    }
    private  boolean esCadena(String palabra) {
        return palabra.matches("\".*\"") || palabra.matches("'.?'");
    }

    private  boolean esIdentificador(String palabra) {
        return palabra.matches("[a-zA-z]+([a-zA-Z]||[0-9]||_)*");
    }

    private  boolean esComentario(String palabra) {
        return palabra.matches("#.*");
    }

    private  boolean esComentarioLineas(String palabra) {
        return palabra.matches("#/(.|\\n|\\t|\\r)*/#");
    }

    private  boolean esPalabraReservada(String Palabra) {
        return Palabra.equals("SI")
                || Palabra.toUpperCase().equals("SINO")

                || Palabra.toUpperCase().equals("PARA")
                || Palabra.toUpperCase().equals("MIENTRAS")
                || Palabra.toUpperCase().equals("HACER")
                || Palabra.toUpperCase().equals("INICIO")
                || Palabra.toUpperCase().equals("SELECCIONA")
                || Palabra.toUpperCase().equals("CONTINUAR")
                || Palabra.toUpperCase().equals("DETENER")
                || Palabra.toUpperCase().equals("DEFECTO")
                || Palabra.toUpperCase().equals("VAR")
                || Palabra.toUpperCase().equals("CADENA")
                || Palabra.toUpperCase().equals("VACIO")
                || Palabra.toUpperCase().equals("ENTERO")
                || Palabra.toUpperCase().equals("DECIMAL")
                || Palabra.toUpperCase().equals("CADENA")
                || Palabra.toUpperCase().equals("CARACTER")
                || Palabra.toUpperCase().equals("ALS")
                || Palabra.toUpperCase().equals("BOOL")
                || Palabra.toUpperCase().equals("PUBLICO")
                || Palabra.toUpperCase().equals("PRIVADO")
                || Palabra.toUpperCase().equals("PROTEGIDO")
                || Palabra.toUpperCase().equals("IMPORTAR")
                || Palabra.toUpperCase().equals("ENTERO")
                || Palabra.toUpperCase().equals("RETORNAR")
                || Palabra.toLowerCase().equals("caso");
    }

    private boolean esDelimitador(char ch) {
        return ch == '(' || ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '?' || ch == ';' || '=' == ch || ch == ',' || ch == ')' || ch == '<' || ch == '>' || ch == '!' || ch == '^' || ch == '|' || ch == '&';
    }   
}
