package com.CompiladorHaskellPlusPlus.Gramaticas;
import java_cup.runtime.Symbol;

%%

%{
  // CODIGO EN JAVA
	private String cadena="";
	private int aux;
%}
/* EXPRESIONES REGULARES */
L = [a-zA-ZñÑ]
D = [0-9]
identificador = ({L}|"_")({L}|{D}|"_")*
caracter = "'"[a-zA-ZñÑ]"'"

%state STRING
%cupsym simbolo
%class AnalisisLexico
%cup
%public
%unicode
%line
%char
%ignorecase
%%
<YYINITIAL>{
/* PALABRAS RESERVADAS */

"+" {
	return new Symbol(simbolo.mas, yychar, yyline, yytext());
}

"-" {
	return new Symbol(simbolo.menos, yychar, yyline, yytext());
}

"*" {
	return new Symbol(simbolo.por, yychar, yyline, yytext());
}

"/" {
	return new Symbol(simbolo.div, yychar, yyline, yytext());
}

"'mod'" {
	return new Symbol(simbolo.mod, yychar, yyline, yytext());
}

"'sqrt'" {
	return new Symbol(simbolo.sqrt, yychar, yyline, yytext());
}

"'pot'" {
	return new Symbol(simbolo.pot, yychar, yyline, yytext());
}

"(" {
	return new Symbol(simbolo.para, yychar, yyline, yytext());
}

")" {
	return new Symbol(simbolo.parc, yychar, yyline, yytext());
}

"$" {
	return new Symbol(simbolo.dolar, yychar, yyline, yytext());
}

"let" {
	return new Symbol(simbolo.let, yychar, yyline, yytext());
}

"[" {
	return new Symbol(simbolo.corcha, yychar, yyline, yytext());
}

"]" {
	return new Symbol(simbolo.corchc, yychar, yyline, yytext());
}

"%" {
	return new Symbol(simbolo.porcentaje, yychar, yyline, yytext());
}

"calcular" {
	return new Symbol(simbolo.calcular, yychar, yyline, yytext());
}

"succ" {
	return new Symbol(simbolo.succ, yychar, yyline, yytext());
}

"decc" {
	return new Symbol(simbolo.decc, yychar, yyline, yytext());
}

"min" {
	return new Symbol(simbolo.min, yychar, yyline, yytext());
}

"max" {
	return new Symbol(simbolo.max, yychar, yyline, yytext());
}

"!!" {
	return new Symbol(simbolo.admiracionadmiracion, yychar, yyline, yytext());
}

"sum" {
	return new Symbol(simbolo.sum, yychar, yyline, yytext());
}

"product" {
	return new Symbol(simbolo.product, yychar, yyline, yytext());
}

"revers" {
	return new Symbol(simbolo.revers, yychar, yyline, yytext());
}

"impr" {
	return new Symbol(simbolo.impr, yychar, yyline, yytext());
}

"par" {
	return new Symbol(simbolo.par, yychar, yyline, yytext());
}

"asc" {
	return new Symbol(simbolo.asc, yychar, yyline, yytext());
}

"desc" {
	return new Symbol(simbolo.desc, yychar, yyline, yytext());
}

"length" {
	return new Symbol(simbolo.length, yychar, yyline, yytext());
}

"{" {
	return new Symbol(simbolo.llv1, yychar, yyline, yytext());
}

"}" {
	return new Symbol(simbolo.llv2, yychar, yyline, yytext());
}

"++" {
        return new Symbol(simbolo.masmas, yychar,yyline, yytext()); 
}

"if" {
	return new Symbol(simbolo.si, yychar, yyline, yytext());
}

"then" {
	return new Symbol(simbolo.entonces, yychar, yyline, yytext());
}

"," {
	return new Symbol(simbolo.coma, yychar, yyline, yytext());
}



"else" {
	return new Symbol(simbolo.t_else, yychar, yyline, yytext());
}

"end" {
	return new Symbol(simbolo.end, yychar, yyline, yytext());
}

"=" {
	return new Symbol(simbolo.igual, yychar, yyline, yytext());
}

"==" {
	return new Symbol(simbolo.igualigual, yychar, yyline, yytext());
}

":" {
	return new Symbol(simbolo.dosp, yychar, yyline, yytext());
}

"case" {
	return new Symbol(simbolo.caso, yychar, yyline, yytext());
}

"<" {
	return new Symbol(simbolo.menorque, yychar, yyline, yytext());
}

"<=" {
	return new Symbol(simbolo.menorIgual, yychar, yyline, yytext());
}

">" {
	return new Symbol(simbolo.mayorque, yychar, yyline, yytext());
}

">=" {
	return new Symbol(simbolo.mayorIgual, yychar, yyline, yytext());
}

"!=" {
	return new Symbol(simbolo.diferente, yychar, yyline, yytext());
}

"&&" {
	return new Symbol(simbolo.andd, yychar, yyline, yytext());
}

"||" {
	return new Symbol(simbolo.orr, yychar, yyline, yytext());
}



"\"" {
        cadena+=yytext(); 
        aux=yychar;
        yybegin(STRING);
}



/* RETORNO DE EXPRESIONES REGULARES */

(([0-9])+) {
    return new Symbol(simbolo.num, yychar,yyline,new String(yytext()));
}

(([0-9])+(".")([0-9])+) {
    return new Symbol(simbolo.ndecimal, yychar,yyline,new String(yytext()));
}

{caracter} {
    return new Symbol(simbolo.tchar, yychar,yyline,new String(yytext()));
}

{identificador} {
    return new Symbol(simbolo.identificador, yychar,yyline,new String(yytext()));
}

/* BLANCOS */
[ \n\r\t\f]+ { /* Se ignoran */}

/* Cualquier Otro */
. { 
    javax.swing.JOptionPane.showMessageDialog(null,"Error lexico: "+yytext()); 
}

}

<STRING>{
[\"] {
        cadena+=yytext();  
        String temporal=cadena; 
        cadena="";  
        aux=0;
        yybegin(YYINITIAL); 
        return new Symbol(simbolo.cadena, yychar,yyline,temporal);   }
[^\"] { cadena+=yytext(); }
}
