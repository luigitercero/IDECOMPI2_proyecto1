package com.CompiladorGraphik.Gramaticas;

import java_cup.runtime.Symbol;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.Color;


%%

Comentario      =[#][/] [^\n]* [/][#]
Comentario2     =[#] [^\n]* [\n]
numero          =[0-9]+
ndecimal        = {numero}"."{numero}
identificador 	=([a-zA-Z0-9]|_)+




%class analisis_lexico
%cup
%public


%line
%char

%state EXPRESION 


%{
//VARIALES Y METODOS DEL SCANER
String expresion="";

  




%}
 
%%

<YYINITIAL>{
/* PALABRAS RESERVADAS */
"\""        {yybegin (EXPRESION);}

"+"         { return new Symbol(simbolo.mas,  yychar,yyline,yytext());}
"-"         { return new Symbol(simbolo.menos,yychar,yyline,yytext());}
"*"         { return new Symbol(simbolo.por,  yychar,yyline,yytext());}  
"/"         { return new Symbol(simbolo.div,  yychar,yyline,yytext());}
"("         { return new Symbol(simbolo.parea, yychar,yyline,yytext());}
"^"			{ return new Symbol(simbolo.eleva,yychar,yyline,yytext());}
")"         { return new Symbol(simbolo.parec, yychar,yyline,yytext());}
"="			{ return new Symbol(simbolo.igual,yychar,yyline,yytext());}
"["			{ return new Symbol(simbolo.corcha,yychar,yyline,yytext());}
"]"			{ return new Symbol(simbolo.corchc,yychar,yyline,yytext());}

"{" 	    { return new Symbol(simbolo.llv1,        yychar,yyline,yytext());}
"}" 		{ return new Symbol(simbolo.llv2,        yychar,yyline,yytext());}
"," 		{ return new Symbol(simbolo.coma,        yychar,yyline,yytext());}
":" 		{ return new Symbol(simbolo.dosp,        yychar,yyline,yytext());}
";"			{ return new Symbol(simbolo.puntocoma,	yychar,yyline,yytext());}
"||"		{ return new Symbol(simbolo.orr, 		yychar,yyline,yytext());}
"&|"		{ return new Symbol(simbolo.xorr,		yychar,yyline,yytext());}
"&&"		{ return new Symbol(simbolo.andd,		yychar,yyline,yytext());}
"not"       { return new Symbol(simbolo.nott,		yychar,yyline, yytext());}
"++"        { return new Symbol(simbolo.  	masmas	,yychar,yyline,yytext());}	
"--"        { return new Symbol(simbolo.  	menosmenos	,yychar,yyline,yytext());}
"?"	        { return new Symbol(simbolo.  	finexp	,yychar,yyline,yytext());}


">"         { return new Symbol(simbolo.mayorque,yychar,yyline,yytext());}
"<"         { return new Symbol(simbolo.menorque,yychar,yyline,yytext());}
">="        { return new Symbol(simbolo.mayorIgual,yychar,yyline,yytext());}
"<="        { return new Symbol(simbolo.menorIgual,        yychar,yyline, yytext());}
"=="        { return new Symbol(simbolo.igualIgual,        yychar,yyline, yytext());}
"!="        { return new Symbol(simbolo.noIgual,        yychar,yyline, yytext());}
	
"verdadero" { return new Symbol(simbolo.  	verdadero	,yychar,yyline, yytext()); }
"falso"     { return new Symbol(simbolo.  	falso	,yychar,yyline, yytext()); }
"publico"	{ return new Symbol(simbolo.  	publico	,yychar,yyline, yytext()); }	
"protegido" { return new Symbol(simbolo.  	protegido	,yychar,yyline, yytext()); }	
"privado"	{ return new Symbol(simbolo.  	privado	,yychar,yyline, yytext()); }	
"entero"	{ return new Symbol(simbolo.  	entero	,yychar,yyline, yytext()); }	
"decimal"	{ return new Symbol(simbolo.  	decimal	,yychar,yyline, yytext()); }	
"caracter"	{ return new Symbol(simbolo.  	caracter	,yychar,yyline, yytext()); }	
"cadena"	{ return new Symbol(simbolo.  	cadena	,yychar,yyline, yytext()); }	
"bool"  	{ return new Symbol(simbolo.  	bool	,yychar,yyline, yytext()); }	
"ALS"		{ return new Symbol(simbolo.  	als	,yychar,yyline, yytext()); }	
"vacio" 	{ return new Symbol(simbolo.  	vacio	,yychar,yyline, yytext()); }	
"importar"	{ return new Symbol(simbolo.  	importar	,yychar,yyline, yytext()); }	
"hereda"	{ return new Symbol(simbolo.  	hereda	,yychar,yyline, yytext()); }	
	
"var"		{ return new Symbol(simbolo.  	var	,yychar,yyline, yytext()); }	
"importar"	{ return new Symbol(simbolo.  	importar	,yychar,yyline, yytext()); }	
"nuevo" 	{ return new Symbol(simbolo.  	nuevo	,yychar,yyline, yytext()); }	

"retornar"	{ return new Symbol(simbolo.  	retornar	,yychar,yyline, yytext()); }	
"llamar"	{ return new Symbol(simbolo.  	llamar	,yychar,yyline, yytext()); }	
"Si"		{ return new Symbol(simbolo.  	si	,yychar,yyline, yytext()); }	
"Sino"  	{ return new Symbol(simbolo.  	sino	,yychar,yyline, yytext()); }	
"Selecciona" { return new Symbol(simbolo.  	selecciona	,yychar,yyline, yytext()); }	
"Caso"		{ return new Symbol(simbolo.  	caso	,yychar,yyline, yytext()); }	
"Defecto"	{ return new Symbol(simbolo.  	dedefecto	,yychar,yyline, yytext()); }	
"Para"		{ return new Symbol(simbolo.  	para	,yychar,yyline, yytext()); }	
"Mientras"	{ return new Symbol(simbolo.  	mientras	,yychar,yyline, yytext()); }	
"Hacer" 	{ return new Symbol(simbolo.  	hacer	,yychar,yyline, yytext()); }	
"Continuar" { return new Symbol(simbolo.  	continuar	,yychar,yyline, yytext()); }	
"Terminar"	{ return new Symbol(simbolo.  	terminar	,yychar,yyline, yytext()); }	
"columna"	{ return new Symbol(simbolo.  	columna	,yychar,yyline, yytext()); }	
"Procesar"	{ return new Symbol(simbolo.  	procesar	,yychar,yyline, yytext()); }	
"Donde"		{ return new Symbol(simbolo.  	donde	,yychar,yyline, yytext()); }	
"DondeCada"	{ return new Symbol(simbolo.  	dondeCadena	,yychar,yyline, yytext()); }	
"DondeTodo"	{ return new Symbol(simbolo.  	dondeTodo	,yychar,yyline, yytext()); }	
"imprimir"	{ return new Symbol(simbolo.  	imprimir	,yychar,yyline, yytext()); }
"incluir_HK"    {return new Symbol(simbolo. incluir_HK  ,yychar,yyline, yytext()); }	
"inicio"        {return new Symbol(simbolo. inicio  ,yychar,yyline, yytext()); }    
"graphikar_funcion" {return new Symbol(simbolo. graphikar_funcion  ,yychar,yyline, yytext()); }



/*RETORNO DE EXPRESIONES REGULARES*/



{numero}        {return new Symbol(simbolo.numero, yychar,yyline,new String(yytext()));}
{ndecimal} 		{return new Symbol(simbolo.ndecimal, yychar, yyline, new String(yytext()));}  

{identificador} {return new Symbol(simbolo.identificador, yychar,yyline, new String(yytext()));}


{Comentario}    {}
{Comentario2}   {}



/* BLANCOS */
[ \n ]+    { /* Se ignoran */}



/* ERRORES LEXICOS */
. {System.out.println("Error lexico: "+yytext());}


}


<EXPRESION>{
[\"] { String temporal=expresion; 
        expresion=""; 
        yybegin(YYINITIAL); 
     
        return new Symbol(simbolo.expresion, yyline+1, yyline, temporal);  }
[^\"] { 
expresion +=yytext();}
}